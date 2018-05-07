/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodolaplace;

import java.io.IOException;

/**
 *
 * @author willi
 */
public class MetodoLaplace {

   
    public static void main(String[] args) throws IOException {
        LaPlace l = new LaPlace();
        l.laplaceMethod();
        System.out.println("Imagem processada");
    }
    
}
