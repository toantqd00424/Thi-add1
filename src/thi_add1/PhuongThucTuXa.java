/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_add1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author MSI
 */
public class PhuongThucTuXa extends UnicastRemoteObject implements KhuonMauTuXa {

    public PhuongThucTuXa() throws RemoteException {
        super();
    }

    @Override
    public double doiDonVi(double a) throws RemoteException {

        double b = a * 0.621371;

        return b;

    }

}
