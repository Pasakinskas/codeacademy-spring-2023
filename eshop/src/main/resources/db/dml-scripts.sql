INSERT INTO PRODUCT(PRODUCT_ID, NAME, PRICE, AMOUNT)
VALUES
    ('260f7043-d0bf-4d99-b143-6ee555685561', 'Limes', 48.0, 79),  -- id: 1
    ('260f7043-d0bf-4d99-b143-6ee555685560', 'Samsung', 222.0, 3),  -- id: 2
    ('260f7043-d0bf-4d99-b143-6ee555685562', 'Passion fruit', 58.0, 3),
    ('260f7043-d0bf-4d99-b143-6ee555685563', 'Mulberries', 41.0, 77),
    ('260f7043-d0bf-4d99-b143-6ee555685564', 'Cumquat', 63.0, 69),
    ('260f7043-d0bf-4d99-b143-6ee555685565', 'Watermelon', 39.0, 75),
    ('260f7043-d0bf-4d99-b143-6ee555685566', 'Juniper Berries', 89.0, 86),
    ('260f7043-d0bf-4d99-b143-6ee555685567', 'Currants', 20.0, 62),
    ('260f7043-d0bf-4d99-b143-6ee555685568', 'Cherries', 85.0, 90),
    ('260f7043-d0bf-4d99-b143-6ee555685569', 'Lemon', 77.0, 86),
    ('260f7043-d0bf-4d99-b143-6ee555685570', 'Dates', 19.0, 59),
    ('260f7043-d0bf-4d99-b143-6ee555685571', 'Honeydew melon', 49.0, 7),
    ('260f7043-d0bf-4d99-b143-6ee555685572', 'cumquat', 22.0, 19);

insert into PRODUCT_CATEGORY(NAME)
VALUES ('Phone'),
       ('Food'),
       ('Drink'),
       ('Other');

insert into PRODUCT_PRODUCT_CATEGORIES(product_id, product_categories_id)
VALUES (1, 2),
       (2, 1);