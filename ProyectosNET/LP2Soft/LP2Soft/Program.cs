using LP2SoftRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LP2Soft
{
    internal static class Program
    {
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(true);
            Empleado emp = new Empleado();
            emp.Cargo = "administrador";
            Application.Run(new frmPrincipal());
        }
    }
}
