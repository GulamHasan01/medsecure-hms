-------------------------------------------------------
-- USERS DATA
-------------------------------------------------------

INSERT INTO users (name, username, role, address, phone_no, password, email)
VALUES
('Admin User', 'admin_db', 'ADMIN', 'Delhi', '9999999999', 'dummy', 'admin@test.com'),

('Doctor Raj', 'doctor_db', 'DOCTOR', 'Mumbai', '8888888888', 'dummy', 'doctor@test.com'),

('Patient Ravi', 'patient_db', 'PATIENT', 'Pune', '7777777777', 'dummy', 'patient@test.com'),

('Nurse Priya', 'nurse_db', 'STAFF', 'Chennai', '6666666666', 'dummy', 'nurse@test.com'),

('Manager Amit', 'manager_db', 'ADMIN', 'Kolkata', '5555555555', 'dummy', 'manager@test.com');


-------------------------------------------------------
-- HOSPITALS DATA
-------------------------------------------------------

INSERT INTO hospitals (name, address, contact_number, email, license_number, registration_date)
VALUES
('City Hospital', 'Mumbai', '8888888888', 'city@test.com', 'LIC001', '2024-01-01'),

('Apollo Clinic', 'Delhi', '7777777777', 'apollo@test.com', 'LIC002', '2023-12-10'),

('Sunrise Medical', 'Bangalore', '6666666666', 'sunrise@test.com', 'LIC003', '2024-02-15'),

('Green Valley Care', 'Pune', '5555555555', 'green@test.com', 'LIC004', '2023-11-20'),

('Global Health Center', 'Hyderabad', '4444444444', 'global@test.com', 'LIC005', '2024-03-01');