INSERT INTO schema_hiber.users (id, age, email, name, password, username)
VALUES (1, 33, 'admin@gmail.com', 'Admin', '$2a$12$msszkBkvAFCV8ee3IeG26uIScwNa2Mk47VVHd11UP57gMTMRpnHae', 'admin');

INSERT INTO schema_hiber.users (id, age, email, name, password, username)
VALUES (2, 33, 'user@gmail.com', 'User', '$2a$12$U0QkgLP.T1DgMoaATnDPy.2nDD5Di4rbzhH5yX2GYgtvbi.sdEqy.', 'user');

INSERT INTO schema_hiber.roles (id, name)
VALUES (1, 'ROLE_ADMIN');

INSERT INTO schema_hiber.roles (id, name)
VALUES (2, 'ROLE_USER');

INSERT INTO schema_hiber.users_roles (user_id, role_id)
VALUES (1, 1);

INSERT INTO schema_hiber.users_roles (user_id, role_id)
VALUES (1, 2);

INSERT INTO schema_hiber.users_roles (user_id, role_id)
VALUES (2, 2);

