﻿using LP2SoftGestClientesModel;
using LP2SoftRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftLogisticaModel.Ventas
{
    public class OrdenVenta
    {
        private int _idOrdenVenta;
        private Cliente _cliente;
        private Empleado _empleado;
        private BindingList<LineaOrdenVenta> lineasOrdenVenta;
        private double _total;
        private DateTime _fechaHora;
        private bool _activo;

        public int IdOrdenVenta { get => _idOrdenVenta; set => _idOrdenVenta = value; }
        public Cliente Cliente { get => _cliente; set => _cliente = value; }
        public Empleado Empleado { get => _empleado; set => _empleado = value; }
        public BindingList<LineaOrdenVenta> LineasOrdenVenta { get => lineasOrdenVenta; set => lineasOrdenVenta = value; }
        public double Total { get => _total; set => _total = value; }
        public DateTime FechaHora { get => _fechaHora; set => _fechaHora = value; }
        public bool Activo { get => _activo; set => _activo = value; }

        public void calcularTotal()
        {
            this._total = 0;
            foreach(LineaOrdenVenta lov in lineasOrdenVenta)
            {
                this._total += lov.Subtotal;
            }
        }
    }
}
