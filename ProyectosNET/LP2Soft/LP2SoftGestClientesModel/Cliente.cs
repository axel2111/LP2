using LP2SoftRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftGestClientesModel
{
    public class Cliente : Persona
    {
        private double _lineaCredito;
        private Categoria _categoria;

        public double LineaCredito { get => _lineaCredito; set => _lineaCredito = value; }
        public Categoria Categoria { get => _categoria; set => _categoria = value; }
    }
}
