﻿
namespace LP2Soft
{
    partial class frmBusquedaOrdenesVenta
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            this.lblBusqueda = new System.Windows.Forms.Label();
            this.txtBusqueda = new System.Windows.Forms.TextBox();
            this.btnBuscar = new System.Windows.Forms.Button();
            this.dgvOrdenesVenta = new System.Windows.Forms.DataGridView();
            this.btnSeleccionar = new System.Windows.Forms.Button();
            this.IdOrdenVenta = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.DNICliente = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NombreCliente = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Fecha = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Total = new System.Windows.Forms.DataGridViewTextBoxColumn();
            ((System.ComponentModel.ISupportInitialize)(this.dgvOrdenesVenta)).BeginInit();
            this.SuspendLayout();
            // 
            // lblBusqueda
            // 
            this.lblBusqueda.AutoSize = true;
            this.lblBusqueda.Location = new System.Drawing.Point(20, 16);
            this.lblBusqueda.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblBusqueda.Name = "lblBusqueda";
            this.lblBusqueda.Size = new System.Drawing.Size(344, 16);
            this.lblBusqueda.TabIndex = 0;
            this.lblBusqueda.Text = "Ingrese el número de Venta o el DNI/Nombre del Cliente:";
            // 
            // txtBusqueda
            // 
            this.txtBusqueda.Location = new System.Drawing.Point(403, 11);
            this.txtBusqueda.Margin = new System.Windows.Forms.Padding(4);
            this.txtBusqueda.Name = "txtBusqueda";
            this.txtBusqueda.Size = new System.Drawing.Size(316, 22);
            this.txtBusqueda.TabIndex = 1;
            // 
            // btnBuscar
            // 
            this.btnBuscar.Location = new System.Drawing.Point(728, 9);
            this.btnBuscar.Margin = new System.Windows.Forms.Padding(4);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(100, 28);
            this.btnBuscar.TabIndex = 2;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscar_Click);
            // 
            // dgvOrdenesVenta
            // 
            this.dgvOrdenesVenta.AllowUserToAddRows = false;
            this.dgvOrdenesVenta.AllowUserToDeleteRows = false;
            this.dgvOrdenesVenta.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvOrdenesVenta.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.IdOrdenVenta,
            this.DNICliente,
            this.NombreCliente,
            this.Fecha,
            this.Total});
            this.dgvOrdenesVenta.Location = new System.Drawing.Point(24, 48);
            this.dgvOrdenesVenta.Margin = new System.Windows.Forms.Padding(4);
            this.dgvOrdenesVenta.Name = "dgvOrdenesVenta";
            this.dgvOrdenesVenta.ReadOnly = true;
            this.dgvOrdenesVenta.RowHeadersWidth = 51;
            this.dgvOrdenesVenta.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvOrdenesVenta.Size = new System.Drawing.Size(1027, 252);
            this.dgvOrdenesVenta.TabIndex = 3;
            this.dgvOrdenesVenta.CellFormatting += new System.Windows.Forms.DataGridViewCellFormattingEventHandler(this.dgvOrdenesVenta_CellFormatting);
            // 
            // btnSeleccionar
            // 
            this.btnSeleccionar.Location = new System.Drawing.Point(893, 9);
            this.btnSeleccionar.Margin = new System.Windows.Forms.Padding(4);
            this.btnSeleccionar.Name = "btnSeleccionar";
            this.btnSeleccionar.Size = new System.Drawing.Size(157, 28);
            this.btnSeleccionar.TabIndex = 4;
            this.btnSeleccionar.Text = "Seleccionar";
            this.btnSeleccionar.UseVisualStyleBackColor = true;
            this.btnSeleccionar.Click += new System.EventHandler(this.btnSeleccionar_Click);
            // 
            // IdOrdenVenta
            // 
            this.IdOrdenVenta.HeaderText = "Id Orden Venta";
            this.IdOrdenVenta.MinimumWidth = 6;
            this.IdOrdenVenta.Name = "IdOrdenVenta";
            this.IdOrdenVenta.ReadOnly = true;
            this.IdOrdenVenta.Width = 131;
            // 
            // DNICliente
            // 
            this.DNICliente.HeaderText = "DNI del Cliente";
            this.DNICliente.MinimumWidth = 6;
            this.DNICliente.Name = "DNICliente";
            this.DNICliente.ReadOnly = true;
            this.DNICliente.Width = 150;
            // 
            // NombreCliente
            // 
            this.NombreCliente.HeaderText = "Nombre del Cliente";
            this.NombreCliente.MinimumWidth = 6;
            this.NombreCliente.Name = "NombreCliente";
            this.NombreCliente.ReadOnly = true;
            this.NombreCliente.Width = 270;
            // 
            // Fecha
            // 
            this.Fecha.HeaderText = "Fecha";
            this.Fecha.MinimumWidth = 6;
            this.Fecha.Name = "Fecha";
            this.Fecha.ReadOnly = true;
            this.Fecha.Width = 130;
            // 
            // Total
            // 
            dataGridViewCellStyle1.Format = "N2";
            this.Total.DefaultCellStyle = dataGridViewCellStyle1;
            this.Total.HeaderText = "Total";
            this.Total.MinimumWidth = 6;
            this.Total.Name = "Total";
            this.Total.ReadOnly = true;
            this.Total.Width = 125;
            // 
            // frmBusquedaOrdenesVenta
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1067, 315);
            this.Controls.Add(this.btnSeleccionar);
            this.Controls.Add(this.dgvOrdenesVenta);
            this.Controls.Add(this.btnBuscar);
            this.Controls.Add(this.txtBusqueda);
            this.Controls.Add(this.lblBusqueda);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "frmBusquedaOrdenesVenta";
            this.Text = "Formulario de Búsqueda de Órdenes de Venta";
            ((System.ComponentModel.ISupportInitialize)(this.dgvOrdenesVenta)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblBusqueda;
        private System.Windows.Forms.TextBox txtBusqueda;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.DataGridView dgvOrdenesVenta;
        private System.Windows.Forms.Button btnSeleccionar;
        private System.Windows.Forms.DataGridViewTextBoxColumn IdOrdenVenta;
        private System.Windows.Forms.DataGridViewTextBoxColumn DNICliente;
        private System.Windows.Forms.DataGridViewTextBoxColumn NombreCliente;
        private System.Windows.Forms.DataGridViewTextBoxColumn Fecha;
        private System.Windows.Forms.DataGridViewTextBoxColumn Total;
    }
}