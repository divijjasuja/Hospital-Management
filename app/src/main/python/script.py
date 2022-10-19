import mysql.connector as m
def add_rec(rec):
    while True:
        db = m.connect(host = "localhost", user = "root", passwd = "(0)".format(pwd), database = "%S"%A)
        cursor =  db.cursor()
        cursor.execute("desc %s" % t)
        d = cursor.fetchall()
        #for a in d:
        #     c.append(input("Enter (0):".format(a[0])))
        # i = 'insert into %s values(' % t
        # for j in c:
        #     if j == c[0]:
        #         if j.isdigit():
        #             None
        #         else:
        #     else:
        #         j = "'" +j +"'"
        #     p = (',' + j)
        #     i += p
        # i += ')'
        #
        cursor.execute(i)
        db.commit()

def delete_data():
    while True:
        try:
            db = m.connect(host="localhost", user="root", passwd="{0}".format(pwd), database="%s" % A)