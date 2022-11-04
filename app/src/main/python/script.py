import mysql.connector as m

def fetch_data(t):
    try:
        db = m.connect(host = "localhost",  user = "root", passwd = "password", database = "%s"%A)
        cursor = db.cursor()
        cursor.execute("desc %s"%t)
        x= cursor.fetchall()
        l=[]
        for i in x:
            l.append(i[0])
        cursor.execute("Select * from %s"%t)
        records=cursor.fetchall()
        for i in range(len(records)):
            records[i] = string(records[i])
        return records
        """ for i in records:
            s.add_row(i)
        print(s.get_string(title='Records in table %s'%t)) """
    except:
        print("***************Error, unable to fetch data**************")