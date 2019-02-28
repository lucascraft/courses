import sqlite3

datafile = 'db.sqlite3'
datadir = 'C:/Users/lucas/git/courses/DjangoSample1/'

db = datadir + datafile

conn = sqlite3.connect(db)

cur = conn.cursor()

cur.execute("""DROP TABLE IF  EXISTS restWMS_product;""");

cur.execute("""CREATE TABLE IF NOT EXISTS restWMS_product (
 name text NOT NULL,
 code text,
 price float
);""")

values = [["crepe", "1", 4.5], ["sandwich", "2", 7.5]]

for v in values:
    row = """INSERT INTO restWMS_product (name, code, price) VALUES ('""" + v[0] + """', '""" + v[1] + """', """ + str(v[2]) + """);"""
    print(row)
    cur.execute(row)


if __name__ == '__main__':
    pass