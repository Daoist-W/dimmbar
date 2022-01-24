use dimmbar;

-- for testing purposes only
 CREATE USER 'dev'@'localhost';
GRANT ALL ON dimmbar.* TO 'dev'@'localhost';

CREATE USER 'dimmbaradmin'@'localhost' IDENTIFIED BY 'D1mb@rr@dm1n1342';
GRANT ALL ON dimmbar.* TO 'dimmbaradmin'@'localhost';

CREATE USER 'dimmbarmanager'@'localhost' IDENTIFIED BY 'D1mb@rrman@g3r9468';
GRANT INSERT ON dimmbar.* TO 'dimmbarmanager'@'localhost';
GRANT SELECT ON dimmbar.* TO 'dimmbarmanager'@'localhost';
GRANT UPDATE ON dimmbar.* TO 'dimmbarmanager'@'localhost';
GRANT DELETE ON dimmbar.* TO 'dimmbarmanager'@'localhost';

CREATE USER 'dimmbarstaff'@'localhost' IDENTIFIED BY 'D1mb@rrst@ff';
GRANT SELECT ON dimmbar.* TO 'dimmbarstaff'@'localhost';

