
-- Insert Users
INSERT INTO app_user (id, email, name, password) VALUES
                                                     (1, 'user1@example.com', 'User One', 'password1'),
                                                     (2, 'user2@example.com', 'User Two', 'password2');

-- Insert Measure Units
INSERT INTO measure_unit (name, type) VALUES
                                          ('Pounds', 0),
                                          ('Kilograms', 0),
                                          ('Bunches', 1);

-- Insert Crops for User 1
INSERT INTO crop (id, name, measure_unit_name, user_id) VALUES
                                                            (1, 'Tomatoes', 'Pounds', 1),
                                                            (2, 'Potatoes', 'Kilograms', 1),
                                                            (3, 'Carrots', 'Kilograms', 1),
                                                            (4, 'Lettuce', 'Bunches', 1);

-- Insert Crops for User 2
INSERT INTO crop (id, name, measure_unit_name, user_id) VALUES
                                                            (5, 'Apples', 'Pounds', 2),
                                                            (6, 'Oranges', 'Kilograms', 2),
                                                            (7, 'Peaches', 'Kilograms', 2),
                                                            (8, 'Cucumbers', 'Bunches', 2),
                                                            (9, 'Strawberries', 'Pounds', 2),
                                                            (10, 'Blueberries', 'Pounds', 2);

-- Insert Harvest Fields for User 1
INSERT INTO harvest_field (id, name, user_id) VALUES
                                                  (1, 'Field A', 1),
                                                  (2, 'Field B', 1),
                                                  (3, 'Field C', 1);

-- Insert Harvest Fields for User 2
INSERT INTO harvest_field (id, name, user_id) VALUES
                                                  (4, 'Field D', 2),
                                                  (5, 'Field E', 2),
                                                  (6, 'Field F', 2),
                                                  (7, 'Field G', 2);


-- Insert Harvest Entries for User 1 (Crops with id 1 to 4)
INSERT INTO harvest_entry (id, harvest_date, quantity, crop_id) VALUES
                                                                    (1, '2024-11-20', 200.5, 1),
                                                                    (2, '2024-11-19', 150.0, 2),
                                                                    (3, '2024-11-18', 300.0, 3),
                                                                    (4, '2024-10-15', 120.0, 4),
                                                                    (5, '2024-11-17', 180.0, 1),
                                                                    (6, '2024-11-15', 130.0, 2),
                                                                    (7, '2024-11-10', 220.0, 3),
                                                                    (8, '2024-11-05', 110.0, 4),
                                                                    (9, '2024-10-25', 260.0, 1),
                                                                    (10, '2024-10-22', 170.0, 2);

-- Insert into Junction Table for User 1
    INSERT INTO harvest_entry_harvest_fields (harvest_entry_id, harvest_fields_id) VALUES
    (1, 1), (1, 2),
            (2, 1),
            (3, 3),
            (4, 2),
            (5, 2),
            (6, 2),
            (7, 3),
            (8, 1),
            (9, 1),
            (10, 1);