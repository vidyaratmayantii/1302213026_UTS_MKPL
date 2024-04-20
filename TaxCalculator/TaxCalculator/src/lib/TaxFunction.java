package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */
	
	
	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		validateMonthWorking(numberOfMonthWorking);
		int taxableIncome = calculateTaxableIncome(monthlySalary, otherMonthlyIncome, numberOfMonthWorking);
		int taxExemption = calculateTaxExemption(isMarried, numberOfChildren);
		int tax = (int) Math.round(0.05 * (taxableIncome - deductible - taxExemption));
		return Math.max(0, tax); 
	}

	private static void validateMonthWorking(int numberOfMonthWorking) {
		if (numberOfMonthWorking > 12) {
			throw new IllegalArgumentException("More than 12 months working per year");
		}
	}

	private static int calculateTaxableIncome(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking) {
		return (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
	}

	private static int calculateTaxExemption(boolean isMarried, int numberOfChildren) {
		int taxExemption = 54000000;
		if (isMarried) {
			taxExemption += 4500000; 
		}
		taxExemption += Math.min(numberOfChildren, 3) * 4500000; 
		return taxExemption;
	}

}
