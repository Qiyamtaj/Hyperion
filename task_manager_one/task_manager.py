# =====importing libraries===========
from datetime import date

today = (date.today())
# importing date in order to automatically add the date a new task is assigned

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
        menu = input('Select one of the following options below:\n '
                     '\t r - Register a user \n'
                     '\t a - Add a task \n'
                     '\t va - View all tasks \n'
                     '\t vm - View my tasks \n'
                     '\t s - View statistics \n'
                     '\t e - Exit \n').lower()

        # creating a menu and formatting it
        # using .lower in ordr for any userinput to be stored in lower case to avoid confusion

        if menu == 'r':
            # this if statement will execute if the user chooses to add a new user
            new_user = input('\n Please enter username for new user: ')
            new_user_password = input('\n Please enter a password for this user: ')
            confirm_password = input('\n Please confirm your password: ')
            # this will get the relevant information needed for the new user
            while new_user_password != confirm_password:
                confirm_password = input('\n Incorrect password, please try again: ')
                # this will loop until the correct confirmation password is entered
            with open('user.txt', 'a') as users:
                if confirm_password == new_user_password:
                    users.write(f'\n{new_user}, {confirm_password}')
                    # once the correct confirmation password is entered the information will be added to the user txt
                print('\n Relevant information has been successfully added \n')

        elif menu == 'a':
            # this elif statement will execute if the user chooses to add a task
            task_username = input(
                '\n Please enter the username of the individual you would like to assign the task to : ')
            task_title = input('\n Please enter a title for this task: ')
            description = input('\n Please enter a description of this task: ')
            task_due_date = input('\n Please enter a due date for this task: ')
            # getting relevant information for the task
            print('\nTask has been successfully added\n')
            with open('tasks.txt', 'a') as tasks:
                tasks.write(f'\n{task_username}, {task_title}, {description}, {today}, {task_due_date}, No')
                # adding the task to the tasks txt in the correct format

        elif menu == 'va':
            # this elif statement will execute if the view all tasks option is chosen
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

        elif menu == 'vm':
            with open('tasks.txt', 'r') as tasks:
                tasks = tasks.readlines()
                for x in range(len(tasks)):
                    tasks[x] = tasks[x].replace('\n', '')
                    tasks[x] = tasks[x].split(', ')
                    # giving the list an index
                for x in range(len(tasks)):
                    if user == tasks[x][0]:
                        print('\n'
                              '----------------------------------------------------------------------------------------'
                              f'\nTask:\t\t\t\t{tasks[x][1]}'
                              f'\nAssigned to:\t\t{tasks[x][0]}'
                              f'\nDate assigned:\t\t{tasks[x][3]}'
                              f'\nDue date:\t\t\t{tasks[x][4]}'
                              f'\nTask complete?\t\t{tasks[x][5]}'
                              f'\nTask description:\n\t{tasks[x][2]}'
                              f'\n'
                              f'--------------------------------------------------------------------------------------')
                        # using the index in order to correctly print an individual users tasks
        elif menu == 's':
            user_count = 0
            incomplete_tasks = 0
            complete_tasks = 0
            all_tasks = 0
            # adding a starting count
            with open('user.txt', 'r+') as num_user:
                num_user = num_user.readlines()
                for i in range(len(num_user)):
                    user_count += 1
                    # using a for loop to count the amount of users
            with open('tasks.txt', 'r+') as tasks:
                for line in tasks:
                    all_tasks += 1
                    # adding a for loop to count the amount of tasks
                    if 'No' in line:
                        incomplete_tasks += 1

                    elif 'Yes' in line:
                        complete_tasks += 1
                        # using an if and elif statement to add a count to the incomplete and complete statement

            print('\n'
                  '------------------------------------------------------------------------------------------------'
                  '\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tStatistics'
                  f'\nNumber of users: {user_count}'
                  f'\nAmount of tasks: {all_tasks}'
                  f'\nIncomplete tasks: {incomplete_tasks}'
                  f'\nComplete tasks: {complete_tasks}\n'
                  '-------------------------------------------------------------------------------------------------\n')
        elif menu == 'e':
            print('Goodbye, have a wonderful day further <3')
            exit()
            # exiting the code as the user is now done with it

        else:
            print('You have not selected anything on the list, please try again or press "e" to exit\n')
            # prompting the user to make a correct input


else:
    while True:
        menu = input('Select one of the following options below:\n '
                     '\t r - Register a user \n'
                     '\t a - Add a task \n'
                     '\t va - View all tasks \n'
                     '\t vm - View my tasks \n'
                     '\t e - Exit \n').lower()

        # creating a menu and formatting it
        # using .lower in ordr for any userinput to be stored in lower case to avoid confusion

        if menu == 'a':
            # this elif statement will execute if the user chooses to add a task
            task_username = input(
                '\n Please enter the username of the individual you would like to assign the task to : ')
            task_title = input('\n Please enter a title for this task: ')
            description = input('\n Please enter a description of this task: ')
            task_due_date = input('\n Please enter a due date for this task: ')
            # getting relevant information for the task
            print('\nTask has been successfully added\n')
            with open('tasks.txt', 'a') as tasks:
                tasks.write(f'\n{task_username}, {task_title}, {description},{today},{task_due_date}, No')
                # adding the task to the tasks txt in the correct format

        elif menu == 'va':
            # this elif statement will execute if the view all tasks option is chosen
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

        elif menu == 'vm':
            with open('tasks.txt', 'r') as tasks:
                tasks = tasks.readlines()
                for x in range(len(tasks)):
                    tasks[x] = tasks[x].replace('\n', '')
                    tasks[x] = tasks[x].split(', ')
                    # giving the list an index
                for x in range(len(tasks)):
                    if user == tasks[x][0]:
                        print('\n'
                              '--------------------------------------------------------------------------------------'
                              f'\nTask:\t\t\t\t{tasks[x][1]}'
                              f'\nAssigned to:\t\t{tasks[x][0]}'
                              f'\nDate assigned:\t\t{tasks[x][3]}'
                              f'\nDue date:\t\t\t{tasks[x][4]}'
                              f'\nTask complete?\t\t{tasks[x][5]}'
                              f'\nTask description:\n\t{tasks[x][2]}'
                              f'\n'
                              f'------------------------------------------------------------------------------------\n')
                        # using the index in order to correctly print an individual users tasks
        elif menu == 'e':
            print('Goodbye, have a wonderful day further <3')
            exit()
            # exiting the code as the user is now done with it

        else:
            print('You have not selected anything on the list, please try again or press "e" to exit\n')
            # prompting the user to make a correct input
