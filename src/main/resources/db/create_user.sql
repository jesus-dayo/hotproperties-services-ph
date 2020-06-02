INSERT INTO `User`
(
`name`,
`username`,
`password`,
`status`,
`deleted`)
VALUES
(
'admin',
'admin',
'$2a$10$A3xIwkcNXV27bS2h1Ha7/uxLbvMLLk74k1JrkhhmZmD92P1O0Idz2',
'active',
0);

INSERT INTO `Role`
(
`name`)
VALUES
(
'ADMIN');

INSERT INTO `User_Role`
(`users_id`,
`roles_id`)
VALUES
(1,
1);


