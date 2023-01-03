use Assignment_5;
-- select cust_name from Customer natural join Shipment where Shipment.destination='Kolkata' OR Shipment.destination='Chennai' OR Shipment.destination='Mumbai';
-- select distinct(driver_name) from Truck,Shipment where Truck.truck_no= Shipment.truck_no and weight>500;
--  select max(weight) as 'Max_Weight', min(weight) as 'Min_Weight' from Shipment;
--  select distinct(cust_name),avg(weight) from Shipment,Customer where Shipment.cust_id=Customer.cust_id group by cust_name;
--  select distinct(city_name),population from Shipment,City where destination=city_name and weight>100;
--  select destination from Shipment group by destination having count(distinct cust_id)=(select count(cust_id) from Customer);
-- select city_name,max(weight) from Shipment,City where Shipment.destination=City.city_name group by city_name;
-- select cust_name,annual_revenue from Customer,Shipment,Truck where Customer.cust_id=Shipment.cust_id and Truck.truck_no=Shipment.truck_no and driver_name='Anil';
-- select driver_name from Truck,Shipment where Shipment.truck_no=Truck.truck_no group by driver_name having count(distinct destination)=(select count(city_name) from City);
-- select destination,min(weight) from Shipment, City where city_name=destination and population>1000000 group by destination;


