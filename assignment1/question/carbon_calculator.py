import numpy as np

# Calculation constants:
KGCO2_PER_LGAS       = 12.85   # KG of CO2 per litre of gas
KGCO2_PER_M3GAS      = 1.94    # KG of CO2 per cubic meter of gas
M3_PER_GJGAS         = 26.137  # cubic meters (M3) of gas per gigajoule (GJ)
GJ_MANUF_COST        = 120     # total auto manufacturing cost in GJs
GJ_MAINT_COST_PER_YR = 3.8     # auto maintenance cost per year in GJs
KGCO2_PER_TRANSITKM  = 0.18    # transit cost per km in KG of CO2
KGS_PER_METRIC_TON   = 1000    # number of kgs per metric ton
DAYS_PER_YR          = 365     # number of days in a calendar year

# result array access constants:
FUEL_EFF_INDEX       = 0
KMS_DRIVE_INDEX      = 1
CAR_AGE_INDEX        = 2
KMS_TRANSIT_INDEX    = 3

NUM_PARAMS           = 4

def calc_auto_usage (fuel_efficiency, km_per_day):
    """ Purpose: calculates the CO2 emissions for automobile use
        -uses kgCO2 generated per liter of gas as KGCO2_PER_LGAS
        -liters of gas used per year calculated as:
        365  (kms driven per day  fuel efficiency),
        where fuelEfficiency of the car is in liters per km.
        NOTE: fuel efficiency is input to the method as “liters per 100 km”
        
        Args:
        fuel_efficiency (double): fuel efficiency of the car in liters per 100 km,
        km_per_day (int): average kms driven per day
        
        Preconditions: none
        
        Returns: int: carbon footprint of auto usage in kgCO2 cast to an integer
        """
    liters_per_year = DAYS_PER_YR * (km_per_day * (fuel_efficiency/100))
    kgCO2 = KGCO2_PER_LGAS * liters_per_year
    
    return int(kgCO2)

def calc_auto_ownership (age):
    """ Purpose: calculates the CO2 emissions for automobile ownership as:
        kgCO2 for manufacturing + kgCO2 for maintenance
        -manufacturing is GJ_MANUF_COST gigajoules in total, which is spread over the age of the car
        ie:  cost per year = total carbon to manufacture car ÷ age of car in years
        -maintenance is GJ_MAINT_COST_PER_YR gigajoules in a year
        
        NOTE: there is M3_PER_GJ cubic meters (M3) of gas per gigajoule (GJ)
        NOTE: there is KGCO2_PER_M3GAS kg of carbon per cubic meter (M3)
        
        
        Args: age (int): age of the car in years
        
        Preconditions: none
        
        Returns: int: carbon footprint of auto ownership in kgCO2 cast to an integer
        """
    manufacturing = GJ_MANUF_COST / age
    
    kgCO2 = (manufacturing + GJ_MAINT_COST_PER_YR) * M3_PER_GJGAS * KGCO2_PER_M3GAS
    
    return int(kgCO2)

def calc_transit (km_per_day):
    """ Purpose: calculates the CO2 emissions for public transit where,
        KGCO2_PER_TRANSITKM kg of CO2 is generated per km on transit
        
        Parameters:  km_per_day (int): average number of kms per day riding transit
        
        Preconditions: none
        
        Returns: int: carbon footprint of public transit use in kgCO2 cast to an integer
        """
    kgCO2 = km_per_day * DAYS_PER_YR * KGCO2_PER_TRANSITKM
    
    return int(kgCO2)

def calc_carbon_footprint(data):
    """ Purpose: calculates carbon footprint of a person for year as:
        the sum of kgCO2 emissions for automobile usage and ownership and transit use
        converted to metric tons (KGS_PER_METRIC_TON kgs in a metric ton)
        
        Parameters:  data (int[]): an array of data from a single person at the following indices:
        [FUEL_EFF_INDEX]  - their car's fuel efficiency
        [KMS_DRIVE_INDEX] - the average number of kms they drive in a day
        [CAR_AGE_INDEX]   - their car's age in years
        [KMS_TRANSIT_INDEX] - the average number of kms they ride the bus in a day
        
        Preconditions: none
        
        Returns: int: total carbon footprint in metric tons per year as an integer
        """
    auto_usage = 0
    auto_ownership = 0
    transit = 0
    
    auto_usage = calc_auto_usage(data[FUEL_EFF_INDEX], int(data[KMS_DRIVE_INDEX]))
    auto_ownership = calc_auto_ownership(int(data[CAR_AGE_INDEX]))
    transit = calc_transit(int(data[KMS_TRANSIT_INDEX]))
    
    tons = (auto_usage + auto_ownership + transit)
    tons = tons / KGS_PER_METRIC_TON
    
    return int(tons)

def calc_carbon_footprints(data, carbon_footprint_results):
    """ Purpose: calculates carbon foot print of each person in a population
        and store the result in the corresponding index of the 1D result array
        
        Parameters:
        data (double[]): a 2D array of data for a populution where,
        each row represents an individual in the population and
        each column of a row has the following data for that individual:
        -fuel efficiency of their car
        -average kms driven per day
        -the age of their car
        -average kms on transit per day
        carbon_footprint_results (int[]): a 1D array to store the total carbon footprint for each individual
        
        Preconditions: none
        
        Returns: void
        """
    for person in data:
        carbon_footprint_results.append(calc_carbon_footprint(person))

def population_report(carbon_footprints, stats_results):
    """ Purpose: calculates stats (total, max, min and average) of
        carbon footprint data of individuals in a population,
        stores the values of the calculated stats into the array:
        -total stored at index SUM_INDEX
        -max stored at index MAX_INDEX,
        -min stored at index MIN_INDEX,
        -average stored at index AVG_INDEX
        (see constants listed at the top of this file)
        
        Parameters:
        carbon_footprints (int[]): a 1D array of the carbon footprint result for a population,
        stats_results(int[]): a 1D array to store the stats results (total, max, min and average)
        
        Preconditions: none
        
        Returns: void
        """
    stats_results.append(np.sum(carbon_footprints))
    stats_results.append(np.amax(carbon_footprints))
    stats_results.append(np.amin(carbon_footprints))
    stats_results.append(int(np.average(carbon_footprints)))





