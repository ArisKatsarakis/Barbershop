INSERT INTO barbershop_user ( id,email, password, username) values (1, 'info@admin.com',  'admin', 'admin');
INSERT INTO barbershop_user ( id,email, password, username) values (2, 'info@user.com',  'user', 'user');
INSERT INTO Appointment (id, customer_id, barber_id, time, date, type) values (1,1,1, '20:30', '2022-06-10', 'Mallia');
INSERT INTO Appointment (id, customer_id, barber_id, time, date, type) values (2,1,1, '20:00', '2022-06-11', 'Mallia');
INSERT into Barber (barber_id, name) VALUES (1, 'Mixalis');
INSERT into Client (id, address, first_name, last_name, phone) values(1,'Tassou Issak 4', 'Aris', 'Katsarakis', '+30 6943286435' );