USE Assignment_4;

-- 1
-- SELECT PNO FROM PARTS
-- WHERE PNO IN (SELECT DISTINCT(PNO) FROM ODETAILS);
-- 2
-- SELECT * FROM CUSTOMERS 
-- WHERE CNAME LIKE 'S%';
-- 3
-- SELECT PNO,PNAME FROM PARTS
-- WHERE PRICE<19.99;
-- 4
-- SELECT ONO,CNAME FROM ORDERS,CUSTOMERS
-- WHERE ORDERS.CNO=CUSTOMERS.CNO AND SHIPPED IS NULL;
-- 5 
-- SELECT PNAME,PRICE FROM PARTS 
-- WHERE PRICE = (SELECT MIN(PRICE) FROM PARTS);
-- 6
-- SELECT PNAME, PRICE FROM PARTS 
-- WHERE PRICE <(SELECT MIN(PRICE) FROM PARTS WHERE PNAME LIKE 'LAND BEFORE TIME%');
-- 7 
 -- SELECT ENO FROM EMPLOYEES, ZIPCODES WHERE ZIPCODES.ZIP=EMPLOYEES.ZIP AND CITY='fort dodge';
 -- 8
-- SELECT ENAME, HDATE FROM EMPLOYEES WHERE HDATE = (SELECT MIN(HDATE) FROM EMPLOYEES);
-- 9 
-- SELECT PNO, PNAME, PRICE FROM PARTS WHERE PRICE > 20.00 ORDER BY PNO;
-- 10
-- SELECT PNO, PNAME, FORMAT(SUM(PRICE*QTY), 2) AS TOTAL_SALES FROM ODETAILS NATURAL JOIN PARTS GROUP BY PNO;

-- 11
-- SELECT PNO, PNAME, FORMAT(SUM(price*QTY), 2) AS TOTAL_SALES FROM ODETAILS NATURAL JOIN PARTS GROUP BY PNO HAVING TOTAL_SALES > 100.53;
-- 12
--    UPDATE ZIPCODES
--      SET CITY='PARTH'
--     WHERE CITY='COLUMBIA';
-- 13
-- UPDATE ORDERS SET SHIPPED=(SELECT SYSDATE() FROM DUAL) WHERE SHIPPED IS NULL;
-- 14
   --  -> SET PRICE=PRICE-0.1*PRICE 
--     -> WHERE PRICE < 24.00;
-- 15
--  UPDATE PARTS
--  SET QOH = (SELECT MAX(QOH)
--  FROM (SELECT QOH FROM PARTS) AS T) 
--  WHERE QOH < 100;


 



