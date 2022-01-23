class Customer:
    def __init__(self):
        self.data = []
    def customer_inf(self, name, review, location):    
        self.data.append([name, review, location])
    def avg_reviews(self, num):
        self.num_customer = num
        self.sum_reviews_utah = 0
        self.sum_reviews_idaho = 0
        self.counter_utah = 0
        self.counter_idaho = 0
        for x in range(len(self.data)):
            if self.data[x][1] == "Utah":
                self.sum_reviews_utah += int(self.data[x][2])
                #Counter of customers in Utah
                self.counter_utah += 1
            else:
                self.sum_reviews_idaho += int(self.data[x][2])
                #Counter of customers in Idaho
                self.counter_idaho += 1

        self.average_reviews_utah = self.sum_reviews_utah / self.counter_utah
        self.average_reviews_idaho = self.sum_reviews_idaho / self.counter_idaho
        return [self.average_reviews_utah, self.average_reviews_idaho]