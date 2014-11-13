package GUI;
//import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dominik Hofmann
 * @version 1.0.5
 */

public class UnitTable {
	
	public static void main(String[] args) {
		//testsquare();
		Test02();
	}
	
	public static void Test02() {
		double energy_J_low = 0.0;
		double energy_Joule_low = 0.0;
		double energy_kJ_low = 0.0;
		double temperature_C_low = 0.0;
		double temperature_F_low = 0.0;
		double temperature_R_low = 0.0;
		double time_min_low = 0.0;
		double time_h_low = 0.0;
		double time_Std_low = 0.0;
		double pressure_Pas_low = 0.0;
		double pressure_bar_low = 0.0;
		double pressure_Hpas_low = 0.0;
		double pressure_mbar_low = 0.0;
		double pressure_atm_low = 0.0;
		double pressure_Torr_low = 0.0;
		double pressure_psi_low = 0.0;
		double pressure_at_low = 0.0;
		double height_cm_low = 0.0;
		double height_mm_low = 0.0;
		double height_inch_low = 0.0;
		double width_cm_low = 0.0;
		double width_cm_low1 = 0.0;
		double diameter_cm_low = 0.0;
		
		double energy_J_high = 0.0;
		double energy_Joule_high = 0.0;
		double energy_kJ_high = 0.0;
		double temperature_C_high = 0.0;
		double temperature_F_high = 0.0;
		double temperature_R_high = 0.0;
		double time_min_high = 0.0;
		double time_h_high = 0.0;
		double time_Std_high = 0.0;
		double pressure_Pas_high = 0.0;
		double pressure_bar_high = 0.0;
		double pressure_Hpas_high = 0.0;
		double pressure_mbar_high = 0.0;
		double pressure_atm_high = 0.0;
		double pressure_Torr_high = 0.0;
		double pressure_psi_high = 0.0;
		double pressure_at_high = 0.0;
		double height_cm_high = 0.0;
		double height_mm_high = 0.0;
		double height_inch_high = 0.0;
		double width_cm_high = 0.0;
		double width_cm_high1 = 0.0;
		double diameter_cm_high = 0.0;
				
		double energy_J_gradient = 1;
		double energy_Joule_gradient = 1;
		double energy_kJ_gradient = 1000;
		double temperature_C_gradient = 1;
		double temperature_F_gradient = (1/1.8);
		double temperature_R_gradient = 0.8;
		double time_min_gradient = 60;
		double time_h_gradient = 3600;
		double time_Std_gradient = 3600;
		double pressure_Pas_gradient = 1;
		double pressure_bar_gradient = 100000;
		double pressure_Hpas_gradient = 100000;
		double pressure_mbar_gradient = 101.315;
		double pressure_atm_gradient = 101330;
		double pressure_Torr_gradient = 133.32;
		double pressure_psi_gradient = 689.48;
		double pressure_at_gradient = 98066.5;
		double height_cm_gradient = 0.01;
		double height_mm_gradient = 0.001;
		double height_inch_gradient = 0.0254;
		double width_cm_gradient = 3.01;
		double width_cm_gradient1 = 0.01;
		double diameter_cm_gradient = 0.01;		
		
		//Zuweisung der Werte durch die GUI eg energy_J_low = (double)textfield0.getText() etc;
		
		double SI_low_energy_J = energy_J_low * energy_J_gradient;
		double SI_low_energy_Joule = energy_Joule_low * energy_Joule_gradient;
		double SI_low_energy_kJ = energy_kJ_low * energy_kJ_gradient;
		double SI_low_temperature_C = temperature_C_low*temperature_C_gradient;
		double SI_low_temperature_F = temperature_F_low*temperature_F_gradient;
		double SI_low_temperature_R = temperature_R_low*temperature_R_gradient;
		double SI_low_time_min = time_min_low*time_min_gradient;
		double SI_low_time_h = time_h_low*time_h_gradient;
		double SI_low_time_Std = time_Std_low*time_Std_gradient;
		double SI_low_pressure_Pas = pressure_Pas_low*pressure_Pas_gradient;
		double SI_low_pressure_bar = pressure_bar_low*pressure_bar_gradient;
		double SI_low_pressure_Hpas = pressure_Hpas_low*pressure_Hpas_gradient;
		double SI_low_pressure_mbar = pressure_mbar_low*pressure_mbar_gradient;
		double SI_low_pressure_atm = pressure_atm_low*pressure_atm_gradient;
		double SI_low_pressure_Torr = pressure_Torr_low*pressure_Torr_gradient;
		double SI_low_pressure_psi = pressure_psi_low*pressure_psi_gradient;
		double SI_low_pressure_at = pressure_at_low*pressure_at_gradient;
		double SI_low_height_cm = height_cm_low*height_cm_gradient;
		double SI_low_height_mm = height_mm_low*height_mm_gradient;
		double SI_low_height_inch = height_inch_low*height_inch_gradient;
		double SI_low_width_cm = width_cm_low*width_cm_gradient;
		double SI_low_width_cm1 = width_cm_low1*width_cm_gradient1;
		double SI_low_diameter_cm = diameter_cm_low*diameter_cm_gradient;
		
		double SI_high_energy_J = energy_J_high * energy_J_gradient;
		double SI_high_energy_Joule = energy_Joule_high * energy_Joule_gradient;
		double SI_high_energy_kJ = energy_kJ_high * energy_kJ_gradient;
		double SI_high_temperature_C = temperature_C_high*temperature_C_gradient;
		double SI_high_temperature_F = temperature_F_high*temperature_F_gradient;
		double SI_high_temperature_R = temperature_R_high*temperature_R_gradient;
		double SI_high_time_min = time_min_high*time_min_gradient;
		double SI_high_time_h = time_h_high*time_h_gradient;
		double SI_high_time_Std = time_Std_high*time_Std_gradient;
		double SI_high_pressure_Pas = pressure_Pas_high*pressure_Pas_gradient;
		double SI_high_pressure_bar = pressure_bar_high*pressure_bar_gradient;
		double SI_high_pressure_Hpas = pressure_Hpas_high*pressure_Hpas_gradient;
		double SI_high_pressure_mbar = pressure_mbar_high*pressure_mbar_gradient;
		double SI_high_pressure_atm = pressure_atm_high*pressure_atm_gradient;
		double SI_high_pressure_Torr = pressure_Torr_high*pressure_Torr_gradient;
		double SI_high_pressure_psi = pressure_psi_high*pressure_psi_gradient;
		double SI_high_pressure_at = pressure_at_high*pressure_at_gradient;
		double SI_high_height_cm = height_cm_high*height_cm_gradient;
		double SI_high_height_mm = height_mm_high*height_mm_gradient;
		double SI_high_height_inch = height_inch_high*height_inch_gradient;
		double SI_high_width_cm = width_cm_high*width_cm_gradient;
		double SI_high_width_cm1 = width_cm_high1*width_cm_gradient1;
		double SI_high_diameter_cm = diameter_cm_high*diameter_cm_gradient;
		
		
		
		int[][] values = new int[23][4];
		//m
		values[0][0] = 2;
		values[1][0] = 2;
		values[2][0] = 2;
		values[3][0] = 0;
		values[4][0] = 0;
		values[5][0] = 0;
		values[6][0] = 0;
		values[7][0] = 0;
		values[8][0] = 0;
		values[9][0] = -1;
		values[10][0] = -1;
		values[11][0] = -1;
		values[12][0] = -1;
		values[13][0] = -1;
		values[14][0] = -1;
		values[15][0] = -1;
		values[16][0] = -1;		
		values[17][0] = 1;
		values[18][0] = 1;
		values[19][0] = 1;
		values[20][0] = 1;
		values[21][0] = 1;
		values[22][0] = 1;	
		
		//k
		values[0][1] = 1;
		values[1][1] = 1;
		values[2][1] = 1;
		values[3][1] = 0;
		values[4][1] = 0;
		values[5][1] = 0;
		values[6][1] = 0;
		values[7][1] = 0;
		values[8][1] = 0;		
		values[9][1] = 1;
		values[10][1] = 1;
		values[11][1] = 1;
		values[12][1] = 1;
		values[13][1] = 1;
		values[14][1] = 1;
		values[15][1] = 1;
		values[16][1] = 1;
		values[17][1] = 0;
		values[18][1] = 0;
		values[19][1] = 0;
		values[20][1] = 0;
		values[21][1] = 0;
		values[22][1] = 0;	
	
		//s
		values[0][2] = -2;
		values[1][2] = 2;
		values[2][2] = 2;		
		values[3][2] = 0;
		values[4][2] = 0;
		values[5][2] = 0;
		values[6][2] = 1;
		values[7][2] = 1;
		values[8][2] = 1;		
		values[9][2] = -2;
		values[10][2] = -2;
		values[11][2] = -2;
		values[12][2] = -2;
		values[13][2] = -2;
		values[14][2] = -2;
		values[15][2] = -2;
		values[16][2] = 2;		
		values[17][2] = 0;
		values[18][2] = 0;
		values[19][2] = 0;
		values[20][2] = 0;
		values[21][2] = 0;
		values[22][2] = 0;
		
		//K
		values[0][3] = 0;
		values[1][3] = 0;
		values[2][3] = 0;
		values[3][3] = 1;
		values[4][3] = 1;
		values[5][3] = 1;		
		values[6][3] = 0;
		values[7][3] = 0;
		values[8][3] = 0;		
		values[9][3] = 0;
		values[10][3] = 0;
		values[11][3] = 0;
		values[12][3] = 0;
		values[13][3] = 0;		
		values[14][3] = 0;
		values[15][3] = 0;
		values[16][3] = 0;		
		values[17][3] = 0;
		values[18][3] = 0;
		values[19][3] = 0;
		values[20][3] = 0;
		values[21][3] = 0;
		values[22][3] = 0;
		
		System.out.println(toStr(values));
		
	}
	
	public static String toStr(int[][] A) {
		String s = "";
		for (int row = 0; row < A.length; ++row) {
			s += Arrays.toString(A[row]) + "\n";
		}
		return s;
	}
	
	/*public static int Test0(double n) {
		//energy_J_high = n;
		//return energy_J_high * energy_J_gradient;
		return 0;
	}
	
	public static void testsquare() {
		assertEquals(0, Test0(3));
	}*/
	
}
