/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import estructuras.arboles.avl.ArbolAVL;
import estructuras.arboles.b.ArbolB;
import estructuras.listas.dobles.circular.ListaDC;
import estructuras.listas.dobles.ordenada.ListaDO;
import estructuras.listas.simples.ordenada.ListaSO_C;
import estructuras.tabla.hash.TablaHash;
import pojos.Horario;

/**
 *
 * @author g
 */
public class Estructuras {
    // __________________________________	E	S	T	R	U	C	T	U	R	A	S	__________________________________
    public static ListaDO ldo_usuarios = new ListaDO();
    public static ListaDC ldc_edificios = new ListaDC();
    public static ListaSO_C lso_cursos = new ListaSO_C();
    public static ArbolAVL avl_catedraticos = new ArbolAVL();
    public static TablaHash th_estudiantes = new TablaHash();
    public static ArbolB<Horario> b_horarios = new ArbolB<Horario>(5);
}