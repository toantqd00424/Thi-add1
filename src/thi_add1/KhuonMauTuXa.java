/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thi_add1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author MSI
 */
public interface KhuonMauTuXa extends Remote {

    public double doiDonVi(double a) throws RemoteException;

}
