using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftRRHHModel
{
    public class Empleado : Persona
    {
        private string _cargo;
        private double _sueldo;
        private bool _activo;
        private CuentaUsuario _cuentaUsuario;
        private Area _area;

        public Empleado() { }

        public Empleado(string DNI, string nombre, string apellidoPaterno, char genero, DateTime fechaNacimiento, 
            string cargo, double sueldo) : base(DNI,nombre,apellidoPaterno,genero,fechaNacimiento)
        {
            _cargo = cargo;
            _sueldo = sueldo;
        }

        public string Cargo { get { return _cargo;  } set => _cargo = value; }
        public double Sueldo { get => _sueldo; set => _sueldo = value; }
        public bool Activo { get => _activo; set => _activo = value; }
        public CuentaUsuario CuentaUsuario { get => _cuentaUsuario; set => _cuentaUsuario = value; }
        public Area Area { get => _area; set => _area = value; }
    }
}
