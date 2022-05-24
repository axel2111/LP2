namespace LP2Soft
{
    partial class frmPrincipal
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
            this.panelSuperior = new System.Windows.Forms.Panel();
            this.pbCerrar = new System.Windows.Forms.PictureBox();
            this.panelLateral = new System.Windows.Forms.Panel();
            this.btnGestionPedidos = new System.Windows.Forms.Button();
            this.btnListarEmpleados = new System.Windows.Forms.Button();
            this.btnEmpleados = new System.Windows.Forms.Button();
            this.panelLogo = new System.Windows.Forms.Panel();
            this.panelContenedor = new System.Windows.Forms.Panel();
            this.panelSuperior.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbCerrar)).BeginInit();
            this.panelLateral.SuspendLayout();
            this.SuspendLayout();
            // 
            // panelSuperior
            // 
            this.panelSuperior.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(98)))), ((int)(((byte)(47)))), ((int)(((byte)(102)))));
            this.panelSuperior.Controls.Add(this.pbCerrar);
            this.panelSuperior.Dock = System.Windows.Forms.DockStyle.Top;
            this.panelSuperior.Location = new System.Drawing.Point(0, 0);
            this.panelSuperior.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panelSuperior.Name = "panelSuperior";
            this.panelSuperior.Size = new System.Drawing.Size(1325, 91);
            this.panelSuperior.TabIndex = 0;
            this.panelSuperior.MouseDown += new System.Windows.Forms.MouseEventHandler(this.panelSuperior_MouseDown);
            // 
            // pbCerrar
            // 
            this.pbCerrar.Image = global::LP2Soft.Properties.Resources.close_window_xxl;
            this.pbCerrar.Location = new System.Drawing.Point(1239, 17);
            this.pbCerrar.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.pbCerrar.Name = "pbCerrar";
            this.pbCerrar.Size = new System.Drawing.Size(65, 58);
            this.pbCerrar.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbCerrar.TabIndex = 0;
            this.pbCerrar.TabStop = false;
            this.pbCerrar.Click += new System.EventHandler(this.pbCerrar_Click);
            // 
            // panelLateral
            // 
            this.panelLateral.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(230)))), ((int)(((byte)(178)))), ((int)(((byte)(234)))));
            this.panelLateral.Controls.Add(this.btnGestionPedidos);
            this.panelLateral.Controls.Add(this.btnListarEmpleados);
            this.panelLateral.Controls.Add(this.btnEmpleados);
            this.panelLateral.Controls.Add(this.panelLogo);
            this.panelLateral.Dock = System.Windows.Forms.DockStyle.Left;
            this.panelLateral.Location = new System.Drawing.Point(0, 91);
            this.panelLateral.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panelLateral.Name = "panelLateral";
            this.panelLateral.Size = new System.Drawing.Size(291, 586);
            this.panelLateral.TabIndex = 1;
            // 
            // btnGestionPedidos
            // 
            this.btnGestionPedidos.Dock = System.Windows.Forms.DockStyle.Top;
            this.btnGestionPedidos.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnGestionPedidos.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnGestionPedidos.Image = global::LP2Soft.Properties.Resources.icons8_office_70;
            this.btnGestionPedidos.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnGestionPedidos.Location = new System.Drawing.Point(0, 248);
            this.btnGestionPedidos.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnGestionPedidos.Name = "btnGestionPedidos";
            this.btnGestionPedidos.Size = new System.Drawing.Size(291, 74);
            this.btnGestionPedidos.TabIndex = 3;
            this.btnGestionPedidos.Text = "Gestión de Ventas";
            this.btnGestionPedidos.UseVisualStyleBackColor = true;
            this.btnGestionPedidos.Click += new System.EventHandler(this.btnGestionPedidos_Click);
            // 
            // btnListarEmpleados
            // 
            this.btnListarEmpleados.Dock = System.Windows.Forms.DockStyle.Top;
            this.btnListarEmpleados.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnListarEmpleados.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnListarEmpleados.Image = global::LP2Soft.Properties.Resources.listar_empleados_70;
            this.btnListarEmpleados.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnListarEmpleados.Location = new System.Drawing.Point(0, 174);
            this.btnListarEmpleados.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnListarEmpleados.Name = "btnListarEmpleados";
            this.btnListarEmpleados.Size = new System.Drawing.Size(291, 74);
            this.btnListarEmpleados.TabIndex = 2;
            this.btnListarEmpleados.Text = "Listar Empleados";
            this.btnListarEmpleados.UseVisualStyleBackColor = true;
            this.btnListarEmpleados.Click += new System.EventHandler(this.btnListarEmpleados_Click);
            // 
            // btnEmpleados
            // 
            this.btnEmpleados.Dock = System.Windows.Forms.DockStyle.Top;
            this.btnEmpleados.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnEmpleados.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEmpleados.Image = global::LP2Soft.Properties.Resources.icons8_employee_55;
            this.btnEmpleados.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft;
            this.btnEmpleados.Location = new System.Drawing.Point(0, 100);
            this.btnEmpleados.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnEmpleados.Name = "btnEmpleados";
            this.btnEmpleados.Padding = new System.Windows.Forms.Padding(5, 0, 0, 0);
            this.btnEmpleados.Size = new System.Drawing.Size(291, 74);
            this.btnEmpleados.TabIndex = 1;
            this.btnEmpleados.Text = "Gestión Empleados";
            this.btnEmpleados.UseVisualStyleBackColor = true;
            this.btnEmpleados.Click += new System.EventHandler(this.btnEmpleados_Click);
            // 
            // panelLogo
            // 
            this.panelLogo.BackgroundImage = global::LP2Soft.Properties.Resources.logo;
            this.panelLogo.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.panelLogo.Dock = System.Windows.Forms.DockStyle.Top;
            this.panelLogo.Location = new System.Drawing.Point(0, 0);
            this.panelLogo.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panelLogo.Name = "panelLogo";
            this.panelLogo.Size = new System.Drawing.Size(291, 100);
            this.panelLogo.TabIndex = 0;
            // 
            // panelContenedor
            // 
            this.panelContenedor.Dock = System.Windows.Forms.DockStyle.Fill;
            this.panelContenedor.Location = new System.Drawing.Point(291, 91);
            this.panelContenedor.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.panelContenedor.Name = "panelContenedor";
            this.panelContenedor.Size = new System.Drawing.Size(1034, 586);
            this.panelContenedor.TabIndex = 2;
            // 
            // frmPrincipal
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1325, 677);
            this.Controls.Add(this.panelContenedor);
            this.Controls.Add(this.panelLateral);
            this.Controls.Add(this.panelSuperior);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "frmPrincipal";
            this.Text = "frmPrincipal";
            this.panelSuperior.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.pbCerrar)).EndInit();
            this.panelLateral.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panelSuperior;
        private System.Windows.Forms.PictureBox pbCerrar;
        private System.Windows.Forms.Panel panelLateral;
        private System.Windows.Forms.Panel panelContenedor;
        private System.Windows.Forms.Panel panelLogo;
        private System.Windows.Forms.Button btnListarEmpleados;
        private System.Windows.Forms.Button btnEmpleados;
        private System.Windows.Forms.Button btnGestionPedidos;
    }
}