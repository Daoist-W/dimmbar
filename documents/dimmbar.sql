
CREATE DATABASE IF NOT EXISTS dimmbar;
USE dimmbar;

DROP TABLE IF EXISTS Beers;
DROP TABLE IF EXISTS Drinks;
DROP TABLE IF EXISTS Snacks;


##############################################

CREATE TABLE IF NOT EXISTS Beers (
	beer_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_ CHAR(50) NOT NULL,
	price INT NOT NULL,
	subtype CHAR(50) NOT NULL,
	abv INT NOT NULL,
	brewery CHAR(50) NOT NULL,
	PRIMARY KEY(beer_id)
) AUTO_INCREMENT=100;


INSERT INTO Beers (name_, price, subtype, abv, brewery)
VALUES
	("PUNK IPA", 100, "IPA", 54, "BREWDOG"),
	("WAFFLER", 130, "PASTRY STOUT", 100, "GYPSY HILL"),
	("GUINESS", 100, "STOUT", 43, "GUINNESS BREWERY"),
	("HEINEKEN", 100, "LAGER", 50, "HEINEKEN"),
	("DELIRIUM TREMENS", 130, "BEGLIAN GOLDEN ALE", 85, "HUYGHE BREWERY"),
	("SAN MIGUEL", 100, "LAGER", 50, "SAN MIGUEL"),
	("LOST LAGER", 100, "PILSNER", 45, "BREWDOG"),
	("Alaskan Pale", 100, "Golden Pale", 52, "Alaskan Brewing Co., Juneau"),
	("DEAD PONY CLUB", 100, "IPA SESSION", 38, "Alaskan Brewing Co., Juneau"),
	("SAN MIGUEL", 100, "LAGER", 50, "");

##############################################

CREATE TABLE IF NOT EXISTS Drinks (
	drink_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_ CHAR(50) NOT NULL,
	price INT NOT NULL,
	subtype CHAR(50),
	PRIMARY KEY(drink_id)
) AUTO_INCREMENT=200;


INSERT INTO Drinks (name_, price, subtype)
VALUES
	("Orange Juice", 50, "Juice"),
	("Apple Juice", 50, "Juice"),
	("Cranberry Juice", 50, "Juice"),
	("Pineapple Juice", 50, "Juice"),
	("Mango Smoothie", 100, "Smoothie"),
	("Pineapple & Banana Smoothie", 100, "Smoothie"),
	("Peanut Butter & Banana Smoothie", 100, "Smoothie"),
	("Matcha", 50, "Tea"),
	("Green Tea", 40, "Tea"),
	("English Breakfast Tea", 30, "Tea"),
	("Still Water", 1000, "Expensive");

##############################################

CREATE TABLE IF NOT EXISTS Snacks (
	snack_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_ CHAR(50) NOT NULL,
	price INT NOT NULL,
	subtype CHAR(50),
	PRIMARY KEY(snack_id)
) AUTO_INCREMENT=300;

INSERT INTO Snacks (name_, price, subtype)
VALUES
	("French Fries", 50, "Side"),
	("Onion Rings", 20, "Side"),
	("Nachos", 20, "Sharers"),
	("Wings", 20, "Sharers"),
	("Mozzarella Sticks", 20, "Sharers"),
	("Quesadillas", 20, "Sharers"),
	("Burger Sliders", 20, "Sharers"),
	("Ready Salted", 20, "Crisps"),
	("Ready Salted", 20, "Crisps"),
	("Salt & Vinegar", 20, "Crisps");

##############################################

CREATE TABLE IF NOT EXISTS Stock (
	stock_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	type CHAR(50) NOT NULL,
	name_ CHAR(50) NOT NULL,
	quantity INT,
	PRIMARY KEY(stock_id)
) AUTO_INCREMENT=10000;

-- INSERT INTO Snacks (type, name_, quantity)
-- VALUES;


##############################################

CREATE TABLE IF NOT EXISTS Shifts (
	shift_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	staff_id CHAR(50) NOT NULL,
	name_ CHAR(50) NOT NULL,
	check_in_date_time CHAR(20),
	check_out_date_time CHAR(20),
	PRIMARY KEY(shift_id)
) AUTO_INCREMENT=100000;

####:##:##,##:##:##

CREATE TABLE IF NOT EXISTS Staff (
	staff_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_ CHAR(50) NOT NULL,
	PRIMARY KEY(staff_id)
) AUTO_INCREMENT=100000;