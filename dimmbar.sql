
CREATE DATABASE IF NOT EXISTS dimmbar;
USE dimmbar;

CREATE TABLE IF NOT EXISTS Beers (
	beer_id INT UNSIGNED NOT NULL AUTO_INCREMENT,
	name_ CHAR(50) NOT NULL,
	price INT NOT NULL,
	subtype CHAR(50) NOT NULL,
	abv INT NOT NULL,
	brewery CHAR(50) NOT NULL,
	PRIMARY KEY(beer_id)
) AUTO_INCREMENT=1;


INSERT INTO Beers (name_, price, subtype, abv, brewery)
VALUES
	("PUNK IPA", 100, "IPA", 54, "BREWDOG"),
	("WAFFLER", 130, "PASTRY STOUT", 100, "GYPSY HILL"),
	("GUINESS", 100, "STOUT", 43, "GUINNESS BREWERY"),
	("HEINEKEN", 100, "LAGER", 50, "HEINEKEN"),
	("DELIRIUM TREMENS", 130, "BEGLIAN GOLDEN ALE", 85, "HUYGHE BREWERY"),
	("SAN MIGUEL", 100, "LAGER", 50, "");

