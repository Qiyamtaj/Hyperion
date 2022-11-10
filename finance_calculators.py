import math

# importing math just lets the computer know you will be using a math module in your code

bnd_inv = input("\n Choose either 'investment' or 'bond' from the menu below to proceed:"
                "\n \n Investment - to calculate the amount of interest you will earn on interest "
                "\n Bond - to calculate the amount you will have to pay monthly on a home loan "
                "\n \n Enter here: ").upper()

# Here I have made a way for the computer to get the information on whether the user has selected a bond or investment

print("\n Please answer the following questions: ")

# This is just being printed for the purpose of it being more userfriendly

if bnd_inv == "INVESTMENT":
    amount = float(input("\n The amount of money you are depositing: R"))
    int_rate = float(input("\n The interest rate as a percentage:"))
    div_int_rate = int_rate / 100
    # dividing the percentage by 100 in order for it to work in the equation
    year = int(input("\n Number of years you plan on investing: "))
    cmpnd_simp = input("\n Is this compound or simple interest: ").upper()
    if cmpnd_simp == "COMPOUND":
        cmpnd_intrs = math.floor(amount * math.pow((1 + div_int_rate), year))
        print(f"\n Your interest will be R{cmpnd_intrs} if you invest for {year} years.")
    elif cmpnd_simp == "SIMPLE":
        simp_intrs = math.floor(amount * (1 + div_int_rate * year))
        print(f"\n Your interest will be R{simp_intrs} if you invest for {year} years.")

# i have nested if statements within the in order to add the other conditions which can make the final equation possible
# the reason i have done this is because the variables would not be defined if the user decided to calculate for a bond

elif bnd_inv == "BOND":
    home_value = float(input("Current value of house: R"))
    home_intrs = float(input("Interest rate: "))
    months = int(input("Months you plan to repay the bond: "))
    div_home_intrs = home_intrs/100
    home_repay = int(div_home_intrs/12*home_value)/(1 - (1+div_home_intrs/12)**(-months))
    print(f"\n You will have to pay R{home_repay} for the next {months} months in order to fully repay your bond")

# this elif statement calculates the bond repayment amount per month
# this is done by creating variables to store all the information for the equation
# the equation is done once all this information has been entered and then printed out in the string




