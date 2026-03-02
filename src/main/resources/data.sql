-------------------------------------------------------
-- USERS TABLE DATA
-------------------------------------------------------

INSERT INTO users (name, username, role, address, phone_no, password, email)
VALUES
('Admin User', 'admin_db', 'ADMIN', 'Delhi', '9999999999', 'dummy', 'admin@test.com'),

('Doctor Raj', 'doctor_db', 'DOCTOR', 'Mumbai', '8888888888', 'dummy', 'doctor@test.com'),

('Patient Ravi', 'patient_db', 'PATIENT', 'Pune', '7777777777', 'dummy', 'patient@test.com'),

('Manager Amit', 'manager_db', 'ADMIN', 'Kolkata', '6666666666', 'dummy', 'manager@test.com'),

('Nurse Priya', 'nurse_db', 'STAFF', 'Chennai', '5555555555', 'dummy', 'nurse@test.com');


-------------------------------------------------------
-- HOSPITALS TABLE DATA
-------------------------------------------------------

INSERT INTO hospitals (name, email, address, contact_number, license_number, registration_date)
VALUES
('City Hospital', 'city@test.com', 'Mumbai', '8888888888', 'LIC001', '2024-01-01'),

('Apollo Clinic', 'apollo@test.com', 'Delhi', '7777777777', 'LIC002', '2023-12-10'),

('Sunrise Medical', 'sunrise@test.com', 'Bangalore', '6666666666', 'LIC003', '2024-02-15'),

('Green Valley Care', 'green@test.com', 'Pune', '5555555555', 'LIC004', '2023-11-20'),

('Global Health Center', 'global@test.com', 'Hyderabad', '4444444444', 'LIC005', '2024-03-01');