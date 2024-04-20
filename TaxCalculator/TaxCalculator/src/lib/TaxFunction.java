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
	
	
	public static int calculateTax(TaxCalculationInput input) {
        validateNumberOfMonthsWorked(input.getNumberOfMonthsWorked());
        int taxableIncome = calculateTaxableIncome(input);
        int taxExemption = calculateTaxExemption(input);
        int tax = (int) Math.round(0.05 * (taxableIncome - input.getDeductible() - taxExemption));
        return Math.max(0, tax);
    }

    private static void validateNumberOfMonthsWorked(int numberOfMonthsWorked) {
        if (numberOfMonthsWorked > 12 || numberOfMonthsWorked <= 0) {
            throw new IllegalArgumentException("Invalid number of months worked");
        }
    }

    private static int calculateTaxableIncome(TaxCalculationInput input) {
        return (input.getMonthlySalary() + input.getOtherMonthlyIncome()) * input.getNumberOfMonthsWorked();
    }

    private static int calculateTaxExemption(TaxCalculationInput input) {
        int taxExemption = 54000000;
        if (input.isMarried()) {
            taxExemption += 4500000;
        }
        taxExemption += Math.min(input.getNumberOfChildren(), 3) * 4500000;
        return taxExemption;
    }

}
