#Import the class customer found in the file module1
from module1 import Customer
#Selecting which program to run
num_program = int(input("Enter number 1(customer shopping) or 2 (customer survey):  "))
if num_program == 1:
    items = []
    prices = []

    option = ""
    discount = ""
    print("Welsome to the Shopping Cart Program:")
    while option != "quit":
        print("Please select one of the following:")
        print("1. Add Items\n2. View Cart\n3. Remove Item\n4. Compute Total\n5. Add Promotion\n6. Quit")
        option = int(input("Please select an action. (Type the number): "))
        print()
    #while name_item != "end":
        if option == 1:
            name_item = ""
            while name_item.lower() != "end":
                name_item = input("What item would you like to add? Type 'END' to stop adding items:  ")
                if name_item.lower() != "end":
                    price_item = float(input("What is the price os this item?:  $"))
                    items.append(name_item)
                    prices.append(price_item)
            print("Your items have been added.\n")    
        elif option == 2:
            x=1
            print("This is your cart: ")
            for item in items:
                print(f"{x}. {item} - ${prices[x-1]}")
                x+=1
            print("")
        elif option == 3:
            x=1
            for item in items:
                print(f"{x}. {item} - ${prices[x-1]}")
                x+=1
            delete = int(input("\nWhich item do you want to delete? Type the number:  "))
            print(f"\nThe item {items[delete-1]} ${prices[delete-1]} is going to be deleted...")
            items.pop(delete-1)
            prices.pop(delete-1)
            print("Item deleted.\n")
        elif option == 4:
            total = float(sum(prices))
            print(f"The total is: $ {total:.2f}\n")
        elif option ==5:
            print("Great if you buy more than 2 items you get a promotion of 20% discount in your total.")
            print("If your total is more than $2000 you will get a 30% discount.")
            print("If you have more than tow 2 itesm and spend more than 2000 you get 40% discount.")
            print("It will be added in the end.")
            discount = "yes"
            print()
        else:
            option = "quit"
    if discount == "yes":
        total_price = float(sum(prices))
        total_items = len(items)
        if total_items > 2 and total_price > 2000:
            print("You bought more than 2 items costing more than $2000!!!!")
            print(f"Your total was: {total_price:.2f}")
            promo = total_price*0.4
            print(f"Your discount applyed is 40%: ${promo:.2f}")
            print(f"\nYour new total is: ${total_price-promo}")
        elif total_items > 2:
            print("You bought more than 2 items")
            print(f"Your total was: {total_price:.2f}")
            promo = total_price*0.2
            print(f"Your discount applyed is 20%: ${promo:.2f}")
            print(f"\nYour new total is: ${total_price-promo}")
        elif total_price > 2000:
            print("You bought more than $2000!!!!")
            print(f"Your total was: {total_price:.2f}")
            promo = total_price*0.3
            print(f"Your discount applyed is 30%: ${promo:.2f}")
            print(f"\nYour new total is: ${total_price-promo}")
        else:
            total = float(sum(prices))
            print(f"Your total is: ${total:.2f}\n")
    print("Thank you. Goodbye.\n")
else:
    #Program 2 customer survey
    test = Customer()
    num_customer = int(input("How many people do you want to send this review survey?:  "))
    for x in range(num_customer):
        #Get name
        name = input("What is your name?: ")
        #Get location
        location = int(input("\nSelect the location (1 or 2):\n1:Utah\n2:Idaho\n\nEnter numher: "))
        if location == 1:
            location = str("Utah")
        else:
            location = str("Idaho")
        #Get review
        review = int(input("\nGive us a review from 1 (lowest review) to 5 (highest review)"))
        test.customer_inf(name, location, review)
    #Option to see the data found in the data list
    answer = input("\nDo you want to see the data?:  ")
    if answer.lower() == "yes":
        print(test.data)
    else:
        pass
    #Here we access to the class Customer to get our average for each location
    final = (test.avg_reviews(num_customer))
    """for x in range(len(test.data)):
        sum_reviews += int(test.data[x][2])
    average_reviews = sum_reviews / num_customer"""
    print("\nThe average review for Utah is: ", final[0])
    print("The average review for Idaho is: ", final[1]) 