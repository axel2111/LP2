using LP2SoftGestClientesModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LP2SoftGestClientesController.DAO
{
    public interface ClienteDAO
    {
        BindingList<Cliente> listarPorNombreDNI(string nombreDNI);
    }
}
