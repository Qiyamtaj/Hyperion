# =====importing libraries===========
from datetime import date

# importing date in order to automatically add the date a new task is assigned
today = (date.today())
count = 0


def reg_user(f):
    new_user = input('\n Please enter a username for the new user: ')
    while new_user in f:
        new_user = input("\n This username is already in use, please enter one that isn't: ")
    if new_user not in f:
        new_user_password = input('\n Please enter a password for this user: ')
        confirm_password = input('\n Please confirm your password: ')
        # this will get the relevant information needed for the new user
        while new_user_password != confirm_password:
            confirm_password = input('\n Incorrect password, please try again: ')
        with open('user.txt', 'a') as users:
            # this will loop until the correct confirmation password is entered
            if confirm_password == new_user_password:
                users.write(f'\n{new_user}, {confirm_password}')
                # once the correct confirmation password is entered the information will be added to the user
                # txt
        print('\n Relevant information has been successfully added \n')


def add_task():
    task_username = input(
        '\n Please enter the username of the individual you would like to assign the task to : ')
    task_title = input('\n Please enter a title for this task: ')
    description = input('\n Please enter a description of this task: ')
    task_due_date = input('\n Please enter a due date for this task (YY-MM-DD): ')
    # getting relevant information for the task
    with open('tasks.txt', 'a') as tasks:
        tasks.write(f'\n{task_username}, {task_title}, {description}, {today}, {task_due_date}, No')
        # adding the task to the tasks txt in the correct format
    print('\nTask has been successfully added\n')


def view_all():
    with open('tasks.txt', 'r+') as tasks:
        # opening the tasks txt as tasks
        for line in tasks:
            # using a for loop to read the data in the txt
            remove_newline_symbols = line.strip('\n')
            # removing the \n as it is a redundancy
            comma_split = remove_newline_symbols.split(', ')
            # splitting the data into a list in order to formate it
            print('\n'
                  '--------------------------------------------------------------------------------------------'
                  f'\nTask:\t\t\t\t{comma_split[1]}'
                  f'\nAssigned to:\t\t{comma_split[0]}'
                  f'\nDate assigned:\t\t{comma_split[3]}'
                  f'\nDue date:\t\t\t{comma_split[4]}'
                  f'\nTask complete?\t\t{comma_split[5]}'
                  f'\nTask description:\n\t{comma_split[2]}'
                  f'\n'
                  f'------------------------------------------------------------------------------------------')
        # formatting the code in order for it to print in the desired outcome


def view_mine():
    data = []
    # creating new list in order to display users task
    all_tasks = []
    all_user_tasks = []
    count = 0
    with open("tasks.txt", "r") as tasks:
        for i, line in enumerate(tasks):
            all_tasks.append(line)
            data = line.split(", ")
            task_complete = data[5].replace("\n", "")
            if data[0].lower() == user.lower():
                all_user_tasks.append(line)
                count += 1
                print('\n'
                      '----------------------------------------------------------------------------------------'
                      f'\nTask number: {count}'
                      f'\nTask:\t\t\t\t{data[1]}'
                      f'\nAssigned to:\t\t{data[0]}'
                      f'\nDate assigned:\t\t{data[3]}'
                      f'\nDue date:\t\t\t{data[4]}'
                      f'\nTask complete?\t\t{data[5]}'
                      f'\nTask description:\n\t{data[2]}'
                      f'\n'
                      f'--------------------------------------------------------------------------------------')

    task_num = int(input("Enter the task number of the task you would like to change: "))

    while task_num > count:
        task_num = int(input("Task not found choose again:"))

    if task_num == -1:
        pass
    else:
        task = all_user_tasks[task_num - 1]
        task = task.split(", ")
        user_edit = int(input("Please enter the option you would like to use "
                              "1 - Mark task as complete\n"
                              "2 - Edit task            \n"
                              "0 - Return               \n"))

        task_done = task[5].replace("\n", "")
        if user_edit == 1 and task_done == "No":
            task[5] = "Yes\n"
            print("Task has been marked as done")
        elif user_edit == 2 and task_done == "No":
            while True:
                edit_choice = input("Please choose the edit you would like to make\n\n"
                                    "\nUsername ---> 1"
                                    "\nDue Date ---> 2"
                                    "\nReturn ---> 0"
                                    "\n-----> ")
                if edit_choice == "1":
                    task[0] = input("Enter username: ")
                elif edit_choice == "2":
                    task[4] = input('Please enter a new Due date (YY/MM/DD)')
                elif edit_choice == "0":
                    break
        elif task_done == "Yes" and user_edit != 0:
            print("Task is already complete")

            print(user_edit)

        elif user_edit == 0:
            pass

        for i, task_data in enumerate(all_tasks):
            if task_data == all_user_tasks[task_num - 1]:
                new_task = ", ".join(task)
                all_tasks[i] = new_task

        with open("tasks.txt", "w") as tasks:
            for line in all_tasks:
                tasks.write(line)


def gen_rep(user):
    incomplete_tasks = 0
    complete_tasks = 0
    all_tasks = 0
    # adding a starting count
    with open('tasks.txt', 'r+') as tasks:
        for line in tasks:
            all_tasks += 1
            # adding a for loop to count the amount of tasks
            if 'No' in line:
                incomplete_tasks += 1

            elif 'Yes' in line:
                complete_tasks += 1
                # using an if and elif statement to add a count to the incomplete and complete statement
    incomplete_percentage = (incomplete_tasks * 100) // all_tasks

    date_today = str(today)
    date_strip = date_today.split('-')

    year = int(date_strip[0])
    month = int(date_strip[1])
    day = int(date_strip[2])

    overdue_tasks = 0

    with open('tasks.txt', 'r') as tasks:
        tasks = tasks.readlines()
        for line in tasks:
            lst = line.replace(', ', '-')
            lst = lst.split('-')

            task_year = int(lst[6])
            task_month = int(lst[7])
            task_day = int(lst[8])

            if 'No' in line:
                if task_year < year:
                    overdue_tasks += 1

                elif task_year >= year and task_month < month:
                    overdue_tasks += 1
                    if task_month >= month and task_day < day:
                        overdue_tasks += 1

    overdue_tasks_percent = (overdue_tasks * 100) // all_tasks

    with open('task_overview.txt', 'w') as task_overview:
        task_overview.write(f'---------------------------------------------------------------------------------------\n'
                            f'Total Tasks: {all_tasks}\n'
                            f'Complete Tasks: {complete_tasks}\n'
                            f'Uncompleted Tasks: {incomplete_tasks}\n'
                            f'% of Uncompleted Tasks: {incomplete_percentage}\n'
                            f'% of Overdue Tasks: {overdue_tasks_percent}\n'
                            f'--------------------------------------------------------------------------------------')
    user_task_count = 0
    user_complete = 0
    user_incomplete = 0
    user_count = 0

    with open('user.txt', 'r+') as user_file:
        for line in user_file:
            user_count += 1
    with open('tasks.txt', 'r+') as tasks:
        tasks = tasks.readlines()
        for line in tasks:
            line = line.split(',')
            if user in line:
                user_task_count += 1
            user_percent = (user_task_count * 100) // all_tasks

            if 'Yes' in line and user in line:
                user_complete += 1

            user_complete = (user_complete * 100) // all_tasks

            if 'No' in line and user in line:
                user_incomplete += 1

            user_incomplete = (user_incomplete * 100) // all_tasks

        date_today = str(today)
        date_strip = date_today.split('-')

        year = int(date_strip[0])
        month = int(date_strip[1])
        day = int(date_strip[2])

        overdue_tasks = 0

        with open('tasks.txt', 'r') as tasks:
            tasks = tasks.readlines()
            for line in tasks:
                lst = line.replace(', ', '-')
                lst = lst.split('-')

                task_year = int(lst[6])
                task_month = int(lst[7])
                task_day = int(lst[8])

                if 'No' in line and user in line:
                    if task_year < year:
                        overdue_tasks += 1
                    elif task_year >= year and task_month < month:
                        overdue_tasks += 1
                        if task_month >= month and task_day < day:
                            overdue_tasks += 1

                    overdue_tasks_percent = (overdue_tasks * 100) // all_tasks

    with open('user_overview.txt', 'w') as user_overview:
        user_overview.write(
            f'---------------------------------------------------------------------------------------\n'
            f'Total Number of user: {user_count}\n'
            f'Total Tasks assigned to {user}: {user_task_count}\n'
            f'% of total tasks assigned to {user}: {user_percent}%\n'
            f'% completed Tasks: {user_complete}%\n'
            f'% of Uncompleted Tasks: {user_incomplete}%\n'
            f'% of Overdue Tasks: {overdue_tasks_percent}%\n'
            f'--------------------------------------------------------------------------------------')


def display_statistics():
    with open('user_overview.txt', 'r+') as user_overview:
        for line in user_overview:
            print(line)
    with open('task_overview.txt', 'r+') as task_overview:
        for line in task_overview:
            print(line)




print("Welcome to task manager\n")

# ====Login Section====

with open('user.txt', 'r') as f:
    f = f.readlines()

for x in range(len(f)):
    f[x] = f[x].strip()
    f[x] = f[x].split(', ')
f = sum(f, [])

# creating a list in order to use it for indexing which can then can be used to make sure the password
# connected to the username

while True:
    user = input('\nPlease enter your username: ')
    # getting input for the username
    if user in f:
        password = input('\nEnter password: ')
        # creating variable for password
        idx = f.index(user)
        # defining the index of user in the list
        if password == f[idx + 1]:
            # if the password is located next to the username you will be logged in
            print('\nLogged in')
            break
        else:
            print('\nInvalid password or username')
    else:
        print('\nPlease enter your information again')

if user == 'admin':
    while True:
        menu = input('\nSelect one of the following options below:\n '
                     '\t r - Register a user \n'
                     '\t a - Add a task \n'
                     '\t gr - Generate reports \n'
                     '\t va - View all tasks \n'
                     '\t vm - View my tasks \n'
                     '\t ds - View statistics \n'
                     '\t e - Exit \n').lower()

        # creating a menu and formatting it
        # using .lower in ordr for any userinput to be stored in lower case to avoid confusion

        if menu == 'r':
            reg_user(f)

        elif menu == 'a':
            add_task()

        elif menu == 'va':
            view_all()
            # formatting the code in order for it to print in the desired outcome

        elif menu == 'vm':
            view_mine()
            # using the index in order to correctly print an individual users tasks
        elif menu == 'gr':
            gen_rep(user)
            print('\nReports have been generated!')

        elif menu == 'ds':
            display_statistics()

        elif menu == 'e':
            print('Goodbye, have a wonderful day further <3')
            exit()
            # exiting the code as the user is now done with it

        else:
            print('You have not selected anything on the list, please try again or press "e" to exit\n')
            # prompting the user to make a correct input


else:
    while True:
        menu = input('\nSelect one of the following options below:\n '
                     '\t r - Register a user \n'
                     '\t a - Add a task \n'
                     '\t va - View all tasks \n'
                     '\t vm - View my tasks \n'
                     '\t e - Exit \n').lower()

        # creating a menu and formatting it
        # using .lower in ordr for any userinput to be stored in lower case to avoid confusion

        if menu == 'a':
            add_task()

        elif menu == 'va':
            view_all()

        elif menu == 'vm':
            view_mine()

        elif menu == 'e':
            print('Goodbye, have a wonderful day further <3')
            exit()
            # exiting the code as the user is now done with it

        else:
            print('You have not selected anything on the list, please try again or press "e" to exit\n')
            # prompting the user to make a correct input


