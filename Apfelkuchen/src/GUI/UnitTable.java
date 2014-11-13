package GUI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Dominik Hofmann
 * @version 1.0.9
 */

public class UnitTable {
	private final int energy_J_gradient = 1;
	private final int energy_Joule_gradient = 1;
	private final int energy_kJ_gradient = 1000;
	private final double temperature_C_gradient = 1;
	private final double temperature_F_gradient = (1 / 1.8);
	private final double temperature_R_gradient = 0.8;
	private final int time_min_gradient = 60;
	private final int time_h_gradient = 3600;
	private final int time_Std_gradient = 3600;
	private final int pressure_Pas_gradient = 1;
	private final int pressure_bar_gradient = 100000;
	private final int pressure_Hpas_gradient = 100000;
	private final double pressure_mbar_gradient = 101.315;
	private final int pressure_atm_gradient = 101330;
	private final double pressure_Torr_gradient = 133.32;
	private final double pressure_psi_gradient = 689.48;
	private final double pressure_at_gradient = 98066.5;
	private final double height_cm_gradient = 0.01;
	private final double height_mm_gradient = 0.001;
	private final double height_inch_gradient = 0.0254;
	private final double width_cm_gradient = 3.01;
	private final double width_cm_gradient1 = 0.01;
	private final double diameter_cm_gradient = 0.01;
	
	private int energy_J_low = 0;
	private int energy_Joule_low = 0;
	private int energy_kJ_low = 0;
	private double temperature_C_low = 0.0;
	private double temperature_F_low = 0.0;
	private double temperature_R_low = 0.0;
	private int time_min_low = 0;
	private int time_h_low = 0;
	private int time_Std_low = 0;
	private int pressure_Pas_low = 0;
	private int pressure_bar_low = 0;
	private int pressure_Hpas_low = 0;
	private double pressure_mbar_low = 0.0;
	private int pressure_atm_low = 0;
	private double pressure_Torr_low = 0.0;
	private double pressure_psi_low = 0.0;
	private double pressure_at_low = 0.0;
	private double height_cm_low = 0.0;
	private double height_mm_low = 0.0;
	private double height_inch_low = 0.0;
	private double width_cm_low = 0.0;
	private double width_cm_low1 = 0.0;
	private double diameter_cm_low = 0.0;
	
	private int energy_J_high = 0;
	private int energy_Joule_high = 0;
	private int energy_kJ_high = 0;
	private double temperature_C_high = 0.0;
	private double temperature_F_high = 0.0;
	private double temperature_R_high = 0.0;
	private int time_min_high = 0;
	private int time_h_high = 0;
	private int time_Std_high = 0;
	private int pressure_Pas_high = 0;
	private int pressure_bar_high = 0;
	private int pressure_Hpas_high = 0;
	private double pressure_mbar_high = 0.0;
	private int pressure_atm_high = 0;
	private double pressure_Torr_high = 0.0;
	private double pressure_psi_high = 0.0;
	private double pressure_at_high = 0.0;
	private double height_cm_high = 0.0;
	private double height_mm_high = 0.0;
	private double height_inch_high = 0.0;
	private double width_cm_high = 0.0;
	private double width_cm_high1 = 0.0;
	private double diameter_cm_high = 0.0;
	
	/** SI_Low_Sums **/
	
	public int SI_low_energy_J() {
		return energy_J_low * energy_J_gradient;
	}
	
	public int SI_low_energy_Joule() {
		return energy_Joule_low * energy_Joule_gradient;
	}
	
	public int SI_low_energy_kJ() {
		return energy_kJ_low * energy_kJ_gradient;
	}
	
	public double SI_low_temperature_C() {
		return temperature_C_low * temperature_C_gradient;
	}
	
	public double SI_low_temperature_F() {
		return temperature_F_low * temperature_F_gradient;
	}
	
	public double SI_low_temperature_R() {
		return temperature_R_low * temperature_R_gradient;
	}
	
	public int SI_low_time_min() {
		return time_min_low * time_min_gradient;
	}
	
	public int SI_low_time_h() {
		return time_h_low * time_h_gradient;
	}
	
	public int SI_low_time_Std() {
		return time_Std_low * time_Std_gradient;
	}
	
	public int SI_low_pressure_Pas() {
		return pressure_Pas_low * pressure_Pas_gradient;
	}
	
	public int SI_low_pressure_bar() {
		return pressure_bar_low * pressure_bar_gradient;
	}
	
	public int SI_low_pressure_Hpas() {
		return pressure_Hpas_low * pressure_Hpas_gradient;
	}
	
	public double SI_low_pressure_mbar() {
		return pressure_mbar_low * pressure_mbar_gradient;
	}
	
	public int SI_low_pressure_atm() {
		return pressure_atm_low * pressure_atm_gradient;
	}
	
	public double SI_low_pressure_Torr() {
		return pressure_Torr_low * pressure_Torr_gradient;
	}
	
	public double SI_low_pressure_psi() {
		return pressure_psi_low * pressure_psi_gradient;
	}
	
	public double SI_low_pressure_at() {
		return pressure_at_low * pressure_at_gradient;
	}
	
	public double SI_low_height_cm() {
		return height_cm_low * height_cm_gradient;
	}
	
	public double SI_low_height_mm() {
		return height_mm_low * height_mm_gradient;
	}
	
	public double SI_low_height_inch() {
		return height_inch_low * height_inch_gradient;
	}
	
	public double SI_low_width_cm() {
		return width_cm_low * width_cm_gradient;
	}
	
	public double SI_low_width_cm1() {
		return width_cm_low1 * width_cm_gradient1;
	}
	
	public double SI_low_diameter_cm() {
		return diameter_cm_low * diameter_cm_gradient;
	}
	
	/** SI_High_Sums **/
	
	public int SI_high_energy_J() {
		return energy_J_high * energy_J_gradient;
	}
	
	public int SI_high_energy_Joule() {
		return energy_Joule_high * energy_Joule_gradient;
	}
	
	public int SI_high_energy_kJ() {
		return energy_kJ_high * energy_kJ_gradient;
	}
	
	public double SI_high_temperature_C() {
		return temperature_C_high * temperature_C_gradient;
	}
	
	public double SI_high_temperature_F() {
		return temperature_F_high * temperature_F_gradient;
	}
	
	public double SI_high_temperature_R() {
		return temperature_R_high * temperature_R_gradient;
	}
	
	public int SI_high_time_min() {
		return time_min_high * time_min_gradient;
	}
	
	public int SI_high_time_h() {
		return time_h_high * time_h_gradient;
	}
	
	public int SI_high_time_Std() {
		return time_Std_high * time_Std_gradient;
	}
	
	public int SI_high_pressure_Pas() {
		return pressure_Pas_high * pressure_Pas_gradient;
	}
	
	public int SI_high_pressure_bar() {
		return pressure_bar_high * pressure_bar_gradient;
	}
	
	public int SI_high_pressure_Hpas() {
		return pressure_Hpas_high * pressure_Hpas_gradient;
	}
	
	public double SI_high_pressure_mbar() {
		return pressure_mbar_high * pressure_mbar_gradient;
	}
	
	public int SI_high_pressure_atm() {
		return pressure_atm_high * pressure_atm_gradient;
	}
	
	public double SI_high_pressure_Torr() {
		return pressure_Torr_high * pressure_Torr_gradient;
	}
	
	public double SI_high_pressure_psi() {
		return pressure_psi_high * pressure_psi_gradient;
	}
	
	public double SI_high_pressure_at() {
		return pressure_at_high * pressure_at_gradient;
	}
	
	public double SI_high_height_cm() {
		return height_cm_high * height_cm_gradient;
	}
	
	public double SI_high_height_mm() {
		return height_mm_high * height_mm_gradient;
	}
	
	public double SI_high_height_inch() {
		return height_inch_high * height_inch_gradient;
	}
	
	public double SI_high_width_cm() {
		return width_cm_high * width_cm_gradient;
	}
	
	public double SI_high_width_cm1() {
		return width_cm_high1 * width_cm_gradient1;
	}
	
	public double SI_high_diameter_cm() {
		return diameter_cm_high * diameter_cm_gradient;
	}
	
	/** Getters/Setters **/
	
	public int getEnergy_J_low() {
		return energy_J_low;
	}
	
	public void setEnergy_J_low(int energy_J_low) {
		this.energy_J_low = energy_J_low;
	}
	
	public int getEnergy_Joule_low() {
		return energy_Joule_low;
	}
	
	public void setEnergy_Joule_low(int energy_Joule_low) {
		this.energy_Joule_low = energy_Joule_low;
	}
	
	public int getEnergy_kJ_low() {
		return energy_kJ_low;
	}
	
	public void setEnergy_kJ_low(int energy_kJ_low) {
		this.energy_kJ_low = energy_kJ_low;
	}
	
	public double getTemperature_C_low() {
		return temperature_C_low;
	}
	
	public void setTemperature_C_low(double temperature_C_low) {
		this.temperature_C_low = temperature_C_low;
	}
	
	public double getTemperature_F_low() {
		return temperature_F_low;
	}
	
	public void setTemperature_F_low(double temperature_F_low) {
		this.temperature_F_low = temperature_F_low;
	}
	
	public double getTemperature_R_low() {
		return temperature_R_low;
	}
	
	public void setTemperature_R_low(double temperature_R_low) {
		this.temperature_R_low = temperature_R_low;
	}
	
	public int getTime_min_low() {
		return time_min_low;
	}
	
	public void setTime_min_low(int time_min_low) {
		this.time_min_low = time_min_low;
	}
	
	public int getTime_h_low() {
		return time_h_low;
	}
	
	public void setTime_h_low(int time_h_low) {
		this.time_h_low = time_h_low;
	}
	
	public int getTime_Std_low() {
		return time_Std_low;
	}
	
	public void setTime_Std_low(int time_Std_low) {
		this.time_Std_low = time_Std_low;
	}
	
	public int getPressure_Pas_low() {
		return pressure_Pas_low;
	}
	
	public void setPressure_Pas_low(int pressure_Pas_low) {
		this.pressure_Pas_low = pressure_Pas_low;
	}
	
	public int getPressure_bar_low() {
		return pressure_bar_low;
	}
	
	public void setPressure_bar_low(int pressure_bar_low) {
		this.pressure_bar_low = pressure_bar_low;
	}
	
	public int getPressure_Hpas_low() {
		return pressure_Hpas_low;
	}
	
	public void setPressure_Hpas_low(int pressure_Hpas_low) {
		this.pressure_Hpas_low = pressure_Hpas_low;
	}
	
	public double getPressure_mbar_low() {
		return pressure_mbar_low;
	}
	
	public void setPressure_mbar_low(double pressure_mbar_low) {
		this.pressure_mbar_low = pressure_mbar_low;
	}
	
	public int getPressure_atm_low() {
		return pressure_atm_low;
	}
	
	public void setPressure_atm_low(int pressure_atm_low) {
		this.pressure_atm_low = pressure_atm_low;
	}
	
	public double getPressure_Torr_low() {
		return pressure_Torr_low;
	}
	
	public void setPressure_Torr_low(double pressure_Torr_low) {
		this.pressure_Torr_low = pressure_Torr_low;
	}
	
	public double getPressure_psi_low() {
		return pressure_psi_low;
	}
	
	public void setPressure_psi_low(double pressure_psi_low) {
		this.pressure_psi_low = pressure_psi_low;
	}
	
	public double getPressure_at_low() {
		return pressure_at_low;
	}
	
	public void setPressure_at_low(double pressure_at_low) {
		this.pressure_at_low = pressure_at_low;
	}
	
	public double getHeight_cm_low() {
		return height_cm_low;
	}
	
	public void setHeight_cm_low(double height_cm_low) {
		this.height_cm_low = height_cm_low;
	}
	
	public double getHeight_mm_low() {
		return height_mm_low;
	}
	
	public void setHeight_mm_low(double height_mm_low) {
		this.height_mm_low = height_mm_low;
	}
	
	public double getHeight_inch_low() {
		return height_inch_low;
	}
	
	public void setHeight_inch_low(double height_inch_low) {
		this.height_inch_low = height_inch_low;
	}
	
	public double getWidth_cm_low() {
		return width_cm_low;
	}
	
	public void setWidth_cm_low(double width_cm_low) {
		this.width_cm_low = width_cm_low;
	}
	
	public double getWidth_cm_low1() {
		return width_cm_low1;
	}
	
	public void setWidth_cm_low1(double width_cm_low1) {
		this.width_cm_low1 = width_cm_low1;
	}
	
	public double getDiameter_cm_low() {
		return diameter_cm_low;
	}
	
	public void setDiameter_cm_low(double diameter_cm_low) {
		this.diameter_cm_low = diameter_cm_low;
	}
	
	public int getEnergy_J_high() {
		return energy_J_high;
	}
	
	public void setEnergy_J_high(int energy_J_high) {
		this.energy_J_high = energy_J_high;
	}
	
	public int getEnergy_Joule_high() {
		return energy_Joule_high;
	}
	
	public void setEnergy_Joule_high(int energy_Joule_high) {
		this.energy_Joule_high = energy_Joule_high;
	}
	
	public int getEnergy_kJ_high() {
		return energy_kJ_high;
	}
	
	public void setEnergy_kJ_high(int energy_kJ_high) {
		this.energy_kJ_high = energy_kJ_high;
	}
	
	public double getTemperature_C_high() {
		return temperature_C_high;
	}
	
	public void setTemperature_C_high(double temperature_C_high) {
		this.temperature_C_high = temperature_C_high;
	}
	
	public double getTemperature_F_high() {
		return temperature_F_high;
	}
	
	public void setTemperature_F_high(double temperature_F_high) {
		this.temperature_F_high = temperature_F_high;
	}
	
	public double getTemperature_R_high() {
		return temperature_R_high;
	}
	
	public void setTemperature_R_high(double temperature_R_high) {
		this.temperature_R_high = temperature_R_high;
	}
	
	public int getTime_min_high() {
		return time_min_high;
	}
	
	public void setTime_min_high(int time_min_high) {
		this.time_min_high = time_min_high;
	}
	
	public int getTime_h_high() {
		return time_h_high;
	}
	
	public void setTime_h_high(int time_h_high) {
		this.time_h_high = time_h_high;
	}
	
	public int getTime_Std_high() {
		return time_Std_high;
	}
	
	public void setTime_Std_high(int time_Std_high) {
		this.time_Std_high = time_Std_high;
	}
	
	public int getPressure_Pas_high() {
		return pressure_Pas_high;
	}
	
	public void setPressure_Pas_high(int pressure_Pas_high) {
		this.pressure_Pas_high = pressure_Pas_high;
	}
	
	public int getPressure_bar_high() {
		return pressure_bar_high;
	}
	
	public void setPressure_bar_high(int pressure_bar_high) {
		this.pressure_bar_high = pressure_bar_high;
	}
	
	public int getPressure_Hpas_high() {
		return pressure_Hpas_high;
	}
	
	public void setPressure_Hpas_high(int pressure_Hpas_high) {
		this.pressure_Hpas_high = pressure_Hpas_high;
	}
	
	public double getPressure_mbar_high() {
		return pressure_mbar_high;
	}
	
	public void setPressure_mbar_high(double pressure_mbar_high) {
		this.pressure_mbar_high = pressure_mbar_high;
	}
	
	public int getPressure_atm_high() {
		return pressure_atm_high;
	}
	
	public void setPressure_atm_high(int pressure_atm_high) {
		this.pressure_atm_high = pressure_atm_high;
	}
	
	public double getPressure_Torr_high() {
		return pressure_Torr_high;
	}
	
	public void setPressure_Torr_high(double pressure_Torr_high) {
		this.pressure_Torr_high = pressure_Torr_high;
	}
	
	public double getPressure_psi_high() {
		return pressure_psi_high;
	}
	
	public void setPressure_psi_high(double pressure_psi_high) {
		this.pressure_psi_high = pressure_psi_high;
	}
	
	public double getPressure_at_high() {
		return pressure_at_high;
	}
	
	public void setPressure_at_high(double pressure_at_high) {
		this.pressure_at_high = pressure_at_high;
	}
	
	public double getHeight_cm_high() {
		return height_cm_high;
	}
	
	public void setHeight_cm_high(double height_cm_high) {
		this.height_cm_high = height_cm_high;
	}
	
	public double getHeight_mm_high() {
		return height_mm_high;
	}
	
	public void setHeight_mm_high(double height_mm_high) {
		this.height_mm_high = height_mm_high;
	}
	
	public double getHeight_inch_high() {
		return height_inch_high;
	}
	
	public void setHeight_inch_high(double height_inch_high) {
		this.height_inch_high = height_inch_high;
	}
	
	public double getWidth_cm_high() {
		return width_cm_high;
	}
	
	public void setWidth_cm_high(double width_cm_high) {
		this.width_cm_high = width_cm_high;
	}
	
	public double getWidth_cm_high1() {
		return width_cm_high1;
	}
	
	public void setWidth_cm_high1(double width_cm_high1) {
		this.width_cm_high1 = width_cm_high1;
	}
	
	public double getDiameter_cm_high() {
		return diameter_cm_high;
	}
	
	public void setDiameter_cm_high(double diameter_cm_high) {
		this.diameter_cm_high = diameter_cm_high;
	}
	public int getEnergy_J_gradient() {
		return energy_J_gradient;
	}

	public int getEnergy_Joule_gradient() {
		return energy_Joule_gradient;
	}

	public int getEnergy_kJ_gradient() {
		return energy_kJ_gradient;
	}

	public double getTemperature_C_gradient() {
		return temperature_C_gradient;
	}

	public double getTemperature_F_gradient() {
		return temperature_F_gradient;
	}

	public double getTemperature_R_gradient() {
		return temperature_R_gradient;
	}

	public int getTime_min_gradient() {
		return time_min_gradient;
	}

	public int getTime_h_gradient() {
		return time_h_gradient;
	}

	public int getTime_Std_gradient() {
		return time_Std_gradient;
	}

	public int getPressure_Pas_gradient() {
		return pressure_Pas_gradient;
	}

	public int getPressure_bar_gradient() {
		return pressure_bar_gradient;
	}

	public int getPressure_Hpas_gradient() {
		return pressure_Hpas_gradient;
	}

	public double getPressure_mbar_gradient() {
		return pressure_mbar_gradient;
	}

	public int getPressure_atm_gradient() {
		return pressure_atm_gradient;
	}

	public double getPressure_Torr_gradient() {
		return pressure_Torr_gradient;
	}

	public double getPressure_psi_gradient() {
		return pressure_psi_gradient;
	}

	public double getPressure_at_gradient() {
		return pressure_at_gradient;
	}

	public double getHeight_cm_gradient() {
		return height_cm_gradient;
	}

	public double getHeight_mm_gradient() {
		return height_mm_gradient;
	}

	public double getHeight_inch_gradient() {
		return height_inch_gradient;
	}

	public double getWidth_cm_gradient() {
		return width_cm_gradient;
	}

	public double getWidth_cm_gradient1() {
		return width_cm_gradient1;
	}

	public double getDiameter_cm_gradient() {
		return diameter_cm_gradient;
	}
	
	public int[][] SI_Values() {
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
		return values;
	}
	
	public static String toStr(int[][] A) {
		String s = "";
		for (int row = 0; row < A.length; ++row) {
			s += Arrays.toString(A[row]) + "\n";
		}
		return s;
	}
	
}
