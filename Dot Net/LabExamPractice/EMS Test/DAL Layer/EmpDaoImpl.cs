﻿using ModelBinding.Models;
using System.Data.SqlClient;
namespace EMS_Test.DAL_Layer
{
    public class EmpDaoImpl : EmpDao
    {
        //private SqlConnection cn;
        public EmpDaoImpl()
        {
            //cn = new SqlConnection();
            //cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True";
            //cn.Open();

        }
        //public void Insert(Employee obj)
        //{

        //    try
        //    {
        //        SqlCommand cmdInsert = new SqlCommand();
        //        cmdInsert.Connection = cn;
        //        cmdInsert.CommandType = System.Data.CommandType.Text;
        //        cmdInsert.CommandText = "insert into Employees values(@EmpNo,@Name,@Basic,@DeptNo)";



        //        cmdInsert.Parameters.AddWithValue("@EmpNo", obj.EmpNo);
        //        cmdInsert.Parameters.AddWithValue("@Name", obj.Name);
        //        cmdInsert.Parameters.AddWithValue("@Basic", obj.Basic);
        //        cmdInsert.Parameters.AddWithValue("@DeptNo", obj.DeptNo);
        //        cmdInsert.ExecuteNonQuery();

        //    }
        //    catch (Exception)
        //    {
        //        throw;
        //    }
        //    finally
        //    {
        //        cn.Close();
        //    }

        //}

        public List<Employee> GetAllEmployees()
        {
            List<Employee> lstEmps = new List<Employee>();
            SqlConnection cn = new SqlConnection();
            cn.ConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=ActsDec2023;Integrated Security=True";
            try
            {
                
                cn.Open();
                SqlCommand cmdInsert = new SqlCommand();
                cmdInsert.Connection = cn;
                cmdInsert.CommandType = System.Data.CommandType.Text;
                cmdInsert.CommandText = "select * from employees ";
                SqlDataReader dr = cmdInsert.ExecuteReader();
                while (dr.Read())
                    lstEmps.Add(new Employee { EmpNo = dr.GetInt32(0), Name = dr.GetString(1), Basic = dr.GetDecimal(2), DeptNo = dr.GetInt32(3) });
                dr.Close();
            }
            catch (Exception ex)
            {
                throw;
            }
            finally
            {
                cn.Close();
            }
            return lstEmps;
        }




    }
}
