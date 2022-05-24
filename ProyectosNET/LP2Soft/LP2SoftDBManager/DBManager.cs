using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftDBManager
{
    public class DBManager
    {
        private static Lazy<DBManager> dbManager = new Lazy<DBManager>();
        private string cadenaConexion = 
            "server=database-lp2.cre3dummjuet.us-east-1.rds.amazonaws.com;" +
            "user=admin;" +
            "password=lp220221;" +
            "database=lp2;" +
            "port=3306;";
        private MySqlConnection con;

        public MySqlConnection getConnection()
        {
            try
            {
                con = new MySqlConnection(cadenaConexion);
            }catch(Exception ex)
            {
                throw new Exception(ex.Message);
            }
            return con;
        }

        public static DBManager Instance
        {
            get
            {
                return dbManager.Value;
            }
        }
    }
}
