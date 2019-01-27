import carbon_calculator

person1 = [16, 19, 12, 18]  # Carbon Footprint 16
person2 = [14.4, 9, 5, 0]   # Carbon Footprint 7
person3 = [10, 2, 20, 9]    # Carbon Footprint 2
    
population1 = [person2]
population3 = [person3, person2, person1]

def main():

    if (test_auto_usage()):
        print("test_auto_usage passed")
    else:
        print("test_auto_usage failed at least one test")

    if (test_auto_ownership()):
        print("test_auto_ownership passed")
    else:
        print("test_auto_ownership failed at least one test")

    if (test_transit()):
        print("test_transit passed")
    else:
        print("test_transit failed at least one test")

    if (test_carbon_footprint()):
        print("test_carbon_footprint passed")
    else:
        print("test_carbon_footprint failed at least one test")

    if (test_population_report()):
        print("test_population_report passed")
    else:
        print("test_population_report failed at least one test")


def test_auto_usage():
    fuel_eff = 14.4
    kms_drive = 9
    result = 0
        
    result = carbon_calculator.calc_auto_usage(fuel_eff, kms_drive)
    #print("should be 6078: ",  result)
    if (result != 6078):
        return False

    fuel_eff = 21.2
    kms_drive = 21
        
    result = carbon_calculator.calc_auto_usage(fuel_eff, kms_drive)
    #print("should be 20880: ", result)
    if (result != 20880):
        return False

    return True

def test_auto_ownership():
    age = 5
    result = 0
        
    result = carbon_calculator.calc_auto_ownership(age)
    #print("should be 1409: ", result)
    if (result != 1409):
        return False

    age = 9
        
    result = carbon_calculator.calc_auto_ownership(age)
    #print("should be 868: ", result)
    if (result != 868):
        return False

    return True

def test_transit():
    kms = 0
    result = 0
        
    result = carbon_calculator.calc_transit(kms)
    #print("should be 0:", result)
    if (result != 0):
        return False
        
    kms = 22
    result = carbon_calculator.calc_transit(kms)
    #print("should be 1445:", result)
    if (result != 1445):
        return False
        
    kms = 2
    result = carbon_calculator.calc_transit(kms)
    #print("should be 131:", result)
    if (result != 131):
        return False
    
    return True

def test_carbon_footprint():
    result = 0
        
    result = carbon_calculator.calc_carbon_footprint(person1)
    #print("should be 16:", result)
    if (result != 16):
        return False
        
    result = carbon_calculator.calc_carbon_footprint(person2)
    #print("should be 7:", result)
    if (result != 7):
        return False
        
    result = carbon_calculator.calc_carbon_footprint(person3)
    #print("should be 2:", result)
    if (result != 2):
        return False

    return True

def test_carbon_footprints():
    result1 = []
    expected1 = [7]
        
    carbon_calculator.calc_carbon_footprints(population1, result1)
    #print("should be:", expected1)
    #print("is:", result1)
        
    if (result1 != expected1):
        return False

    result2 = []
    expected2 = [2, 7, 16]
        
    carbon_calculator.calc_carbon_footprints(population3, result2)
    #print("should be:", expected2)
    #print("is:", result2)
        
    if (result2 != expected2):
        return False
    
    return True

def test_population_report():
    test1 = [20]
    result1 = []
    expected1 = [20, 20, 20, 20]
        
    carbon_calculator.population_report(test1, result1)
    #print("should be:", expected1)
    #print("is:", result1)
    
    if (result1 != expected1):
        return False

    test6 = [20, 50, 10, 89, 72, 19]
    result6 = []
    expected6 = [260, 89, 10, 43]
    
    carbon_calculator.population_report(test6, result6)
    #print("should be:", expected6)
    #print("is:", result6)
        
    if (result6 != expected6):
        return False

    return True


if __name__ == '__main__':
    main()



