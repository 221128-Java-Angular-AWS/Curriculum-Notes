--###########################################################
--#####################     ANSWERS     #####################
--###########################################################

--# Get a list of all customers with the last name 'Smith'.
SELECT * FROM customers
WHERE name LIKE '%Smith'


--# Get the total balance of all accounts held by the Smiths.
SELECT SUM(balance) FROM accounts A
JOIN accounts_customers AC ON A.account_id = AC.account_id 
JOIN customers C ON C.customer_id = AC.customer_id 
WHERE C.name LIKE '%Smith'


--# Get the name and address of any customer with less than $50 in an account. (No duplicates!)
SELECT name, CONCAT(ad.address, ' ', ad.city, ', ', ad.state) AS "address" FROM customers C
JOIN address AD ON C.address_id = AD.address_id 
JOIN accounts_customers AC ON C.customer_id = AC.customer_id 
JOIN accounts A ON AC.account_id = A.account_id 
WHERE balance < 50.00




--# Get a list of all the customers who live in Texas.
SELECT name, A.* FROM customers C
JOIN address A ON C.address_id = A.address_id 
WHERE state LIKE 'TX'


--# Add $100 gift to any accounts belonging to customers in New York
/* Postgres has some weird syntax involving UPDATE and JOIN. The following
 * solution works around that by doing sub-queries instead of JOINs.
 * 
 */
UPDATE accounts 
SET balance = (balance + 100.00)
WHERE account_id IN 
(
	SELECT AC.account_id FROM accounts_customers AC
	WHERE AC.customer_id IN
	(
		SELECT c.customer_id AS id FROM customers C
		JOIN address a ON c.address_id = a.address_id
		WHERE state LIKE 'NY'
	)
)
/* Or we can write it without subqueries, note the interesting join syntax here,
 * the first table joined is with the FROM keyword, and the join condition (the ON part)
 * is in the WHERE clause. Then our filtering logic is combined logically with AND.
 * Subsequent joins happen normally, relative to the first joined table.
 * 
*/

UPDATE accounts A
SET balance = (balance + 100.00)
FROM accounts_customers AC
JOIN customers C ON AC.customer_id = C.customer_id 
JOIN address AD ON C.address_id = AD.address_id 
WHERE A.account_id = AC.account_id 
AND AD.state = 'NY'



--# Transfer $199.99 from Jason Smith to Amanda Smith (This requires two statements)
/* Here we are seeing a quick example of transaction management with BEGIN TRANSACTION
 * and COMMIT TRANSACTION. This treats all statements inside the transaction as one logical
 * group. If any step of the transaction is met with an error, the whole thing will rollback
 * to the beginning. We can also create out own SAVEPOINT to roll back to, and we can
 * use the ROLLBACK keyword to cause a rollback based on some logic if we need to.
 * 
 * So in this example there is no way that the $199.99 is removed from one account,
 * but fails to be added to the other. Either both the withdrawal and the deposit succeed,
 * or we rollback and both fail.
 */
BEGIN TRANSACTION;

UPDATE accounts A
SET balance = balance - 199.99
FROM accounts_customers AC 
JOIN customers C ON AC.customer_id = C.customer_id 
WHERE A.account_id = AC.account_id 
AND A.account_id = '900001';


UPDATE accounts A
SET balance = balance + 199.99
FROM accounts_customers AC 
JOIN customers C ON AC.customer_id = C.customer_id 
WHERE A.account_id = AC.account_id 
AND A.account_id = '900004';

COMMIT TRANSACTION;




--# Change Amanda Smith's last name to 'Lastname'
BEGIN TRANSACTION;
UPDATE customers 
SET name = 'Amanda Lastname'
WHERE name = 'Amanda Smith';
COMMIT TRANSACTION;
