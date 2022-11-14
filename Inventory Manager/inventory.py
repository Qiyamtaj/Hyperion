# importing libraries
from tabulate import tabulate


# creating class

class Shoes:
    def __init__(self, country, code, product, cost, quantity):
        self.country = country
        self.code = code
        self.product = product
        self.cost = cost
        self.quantity = quantity

    def read_shoes_data(self):
        with open('inventory.txt', 'r+') as inventory:
            inventory = inventory.readlines()
            for line in inventory:
                line = line.strip('\n')
                line = line.split(',')
                # removing \n from show object
                lst.append(line)
                # adding data to the lst

    def capture_shoes(self):
        country = input('Please enter the country where the shoe has been shipped from: ')
        code = input('Enter code for this shoe: ')
        product = input('Enter product name :')
        cost = input('Cost of shoe: ')
        quantity = input('Quantity of received shoe: ')
        # capturing correct data to append to list
        with open("inventory.txt", "a") as f:
            f.write(f"\n{country},{code},{product},{cost},{quantity}")
        # appending the new data to the txt file

    def view_all(self):
        print(tabulate(lst, headers='firstrow', tablefmt='fancy_grid', showindex=True))
        # using Pythons tabulate module to format the data in a very coherent and readable way

    def re_stock(self):
        lst_1 = []
        data = []
        lst_2 = []
        with open('inventory.txt', 'r+') as inventory:
            inventory = inventory.readlines()
            for line in inventory:
                line = line.strip('\n')
                line = line.split(',')
                if line[4] == 'Quantity':
                    del line[4]
                else:
                    data.append(int(line[4]))

                # removing Quantity from the data in order to concatenate it in to integers
        lowest = str(min(data))

        # finding the index of the lowest quantity in order to edit it

        with open('inventory.txt', 'r+') as f:
            f = f.readlines()
            for line in f:
                lst_2.append(line)
                line = line.strip('\n')
                line = line.split(',')
                lst_1.append(line)

        for line in lst_1:
            if lowest in line:
                lowest = line
                low_str = ','.join(line)
                idx = inventory.index(f'{low_str}\n')
                edit = input(
                    f' {low_str} has the lowest stock quantity - would you like to add more? (y/n)\n -->  ').lower()
                # asking the user if they would like to add stock
                if edit == 'y':
                    num = (int(lowest[4]))
                    # concatenating the 4th index into an integer in order to do an equation with it
                    amount = int(input('How much stock would you like to add? '))
                    update = str(num + amount)
                    # adding the users entered amount to the existing amount
                    lowest[4] = update
                    # updating the amount
                    lowest = ','.join(lowest)
                    # turning the updated amount in order to replace it
                    lst_2[idx] = f'{lowest}\n'
                    # replacing the old amount with the new amount
                    f = open('inventory.txt', 'w')
                    for x in lst_2:
                        f.write(x)
                    f.close()
                else:
                    pass

    def search_shoe(self):
        shoe_code = input('Please enter the shoe code\n--->').upper()
        # creating variable to store the shoe code
        with open('inventory.txt', 'r+') as f:
            f = f.readlines()
            for line in f:
                if shoe_code in line:
                    print(line)
                    # displaying the information of the entered shoe code

    def value_per_item(self):
        with open('inventory.txt', 'r+') as f:
            f = f.readlines()
            print('Value per shoe')
            for line in f:
                line = line.strip('\n')
                line = line.split(',')
                try:
                    cost = int(line[3])
                    quantity = int(line[4])
                    value = cost * quantity
                    # finding the value
                    print(f'Shoe: {line[2]}\t----- Value: R{value}')

                except ValueError:
                    pass
                # expecting value error as the first line[3] and line[4] can't be concatenated into integers

    def highest_qty(self):
        data = []
        lst1 = []
        with open('inventory.txt', 'r+') as inventory:
            inventory = inventory.readlines()
            for line in inventory:
                line = line.strip('\n')
                line = line.split(',')
                if line[4] == 'Quantity':
                    del line[4]
                else:
                    data.append(int(line[4]))
                # removing Quantity from the data in order to concatenate it in to integers
            highest = str(max(data))

            with open('inventory.txt', 'r+') as f:
                f = f.readlines()
                for line in f:
                    line = line.strip('\n')
                    line = line.split(',')
                    lst1.append(line)

                for line in lst1:
                    if highest in line:
                        high_str = ','.join(line)
                        idx = inventory.index(f'{high_str}\n')
                        return f"{lst1[idx][2]}'s are now 25% off!"


lst = []

while True:
    shoes = Shoes('country', 'code', 'product', 'cost', 'quantity')
    menu = input('\nSelect one of the following options below:\n'
                 '\t ad - Add new product information\n'
                 '\t ds - Display all stock information\n'
                 '\t up - Update the stock with the lowest quantity\n'
                 '\t sr - Search shoe using its product code to see all information on it\n'
                 '\t v - View value of all stock\n'
                 '\t hq - Display the stock with the highest quantity and put it on sale\n'
                 '\t e - Exit \n'
                 '\t----> ').lower()

    if menu == 'ad':
        shoes.capture_shoes()

    elif menu == 'ds':
        shoes.read_shoes_data()
        shoes.view_all()

    elif menu == 'up':
        shoes.re_stock()

    elif menu == 'sr':
        shoes.search_shoe()

    elif menu == 'v':
        shoes.value_per_item()

    elif menu == 'hq':
        shoes.highest_qty()

    elif menu == 'e':
        print('Have a beautiful day further <3')
        exit()

