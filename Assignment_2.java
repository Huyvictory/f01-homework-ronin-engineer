import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Assignment_2 {
    public static void main(String[] args) {
        // Bai 1
        System.out.println("*****************************************");
        Bai1();
        System.out.println("******************************************");

        System.out.println();

        // Bai 2
        System.out.println("*****************************************");
        Bai2();
        System.out.println("******************************************");

        System.out.println();

        // Bai 3
        System.out.println("******************************************");
        Bai3();
        System.out.println("******************************************");

        System.out.println();

        // Bai 4
        System.out.println("******************************************");
        Bai4();
        System.out.println("******************************************");

        System.out.println();

        // Bai 5
        System.out.println("******************************************");
        Bai5();
        System.out.println("******************************************");

        System.out.println();

        // Bai 6
        System.out.println("******************************************");
        Bai6();
        System.out.println("******************************************");

        System.out.println();

        //Bai 7
        System.out.println("******************************************");
        Bai7();
        System.out.println("******************************************");

        System.out.println();

        // Bai 8
        System.out.println("******************************************");
        Bai8();
        System.out.println("******************************************");

        System.out.println();

        // Bai 9
        System.out.println("******************************************");
        Bai9();
        System.out.println("******************************************");

        System.out.println();

        // Bai 10
        System.out.println("******************************************");
        Bai10();
        System.out.println("******************************************");

        System.out.println();
    }

    public static void Bai1() {
        double inchInput;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập so inch");
            inchInput = scanner.nextDouble();

        } while (inchInput <= 0);

        System.out.println("Số inch: " + inchInput + "được chuyển về " + inchInput * 2.54 + " cm");
    }

    public static double ChuyenDoNhietDo(String type, double temperature) {
        if (type.equalsIgnoreCase("C")) {

            return ((9.0 / 5) * temperature) + 32;
        }

        return (5.0 / 9) * (temperature - 32);
    }

    public static void Bai2() {
        Scanner scanner2 = new Scanner(System.in);
        String type;

        do {
            System.out.println("Nhập loại nhiệt độ F hoặc C");
            type = scanner2.nextLine();

        } while (!type.equalsIgnoreCase("F") && !type.equalsIgnoreCase("C"));

        System.out.println("Nhập nhiệt độ cần chuyển đổi");
        double temperature = scanner2.nextDouble();

        System.out.println("Nhiệt đột đả chuyển đổi từ " + type.toUpperCase() + " sang" + (type.equalsIgnoreCase("F") ? " C " : " F ") + ": " + ChuyenDoNhietDo(type, temperature));
    }

    public static void Bai3() {
        Scanner scanner3 = new Scanner(System.in);
        int tongPhut;
        do {
            System.out.println("Nhập số phút");
            tongPhut = scanner3.nextInt();
        } while (tongPhut < 0);

        int soPhutTrongNam = 60 * 24 * 365;
        int soPhutTrongNgay = 60 * 24;
        int soPhutTrongGio = 60;
        int soPhutConLai = 0;

        int soNam = tongPhut / soPhutTrongNam;
        soPhutConLai = tongPhut % soPhutTrongNam;

        int soNgay = soPhutConLai / soPhutTrongNgay;
        soPhutConLai %= soPhutTrongNgay;

        int soGio = soPhutConLai / soPhutTrongGio;
        soPhutConLai %= soPhutTrongGio;

        System.out.printf("%d years, %d days, %d hours, %d minutes%n", soNam, soNgay, soGio, soPhutConLai);
    }

    public static void Bai4() {
        Scanner scanner4 = new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhập n");
            n = scanner4.nextInt();
        } while (n < 0);


        int ketQuaGiaiThua = 1;
        for (int i = 1; i <= n; i++) {
            ketQuaGiaiThua *= i;
        }
        System.out.println("Lũy thừa của số " + n + " là " + ketQuaGiaiThua);
    }

    public static void Bai5() {
        Scanner scanner5 = new Scanner(System.in);
        int soThapPhan;

        System.out.println("Nhập số thập phân thuộc cơ số 10");

        soThapPhan = scanner5.nextInt();


        StringBuilder maNhiPhan = new StringBuilder();
        if (soThapPhan == 0) maNhiPhan.append("0");
        while (soThapPhan > 0) {
            maNhiPhan.insert(0, soThapPhan % 2);
            soThapPhan /= 2;
        }

        System.out.println("Hệ nhị phân: " + maNhiPhan);

        int soThapPhanTuMaNhiPhan = 0;
        int length = maNhiPhan.length();
        for (int i = length - 1; i >= 0; i--) {
            if (maNhiPhan.charAt(i) == '1') {
                soThapPhanTuMaNhiPhan += (int) Math.pow(2, length - i - 1);
            }
        }

        System.out.println("Số thập phân: " + soThapPhanTuMaNhiPhan);
    }

    public static String chuyenVeLaMa(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(symbols[i]);
            }
        }

        return roman.toString();
    }

    public static void Bai6() {
        Scanner scanner6 = new Scanner(System.in);
        int soNguyenDuong;
        do {
            System.out.println("Nhập số nguyên dương nhỏ hơn 1000");
            soNguyenDuong = scanner6.nextInt();
        }
        while (soNguyenDuong < 0 || soNguyenDuong > 1000);

        System.out.println("Sô la mã của số nguyên dương " + soNguyenDuong + " là " + chuyenVeLaMa(soNguyenDuong));
    }

    public static void Bai7() {
        Scanner scanner7 = new Scanner(System.in);
        System.out.println("Nhập số a");
        double a = scanner7.nextDouble();
        System.out.println("Nhập số b");
        double b = scanner7.nextDouble();
        System.out.println("Nhập số c");
        double c = scanner7.nextDouble();

        // Kiểm tra có phải là tam giác hay không
        if (a + b > c && a + c > b && b + c > a) {
            String loaiTamGiac;
            // Xác định loại tam giác
            if (a == b && b == c) {
                loaiTamGiac = "Đều";
            } else if (a == b || b == c || a == c) {
                loaiTamGiac = "Cân";
            } else {
                loaiTamGiac = "Bình thường";
            }

            // Tính chu vi tam giác
            double chuViTamGiac = a + b + c;

            // Tính diện tích tam giác bằng công thức Heron
            double s = chuViTamGiac / 2;
            double dienTichTamGiac = Math.sqrt(s * (s - a) * (s - b) * (s - c));

            System.out.println("Tam giác " + loaiTamGiac);
            System.out.println("Chu vi: " + chuViTamGiac);
            System.out.println("Diện tích: " + dienTichTamGiac);
        } else {
            System.out.println("Không phải là tam giác.");
        }
    }

    public static void Bai8() {
        Scanner scanner8 = new Scanner(System.in);

        System.out.println("Nhập số kiểm tra tính hoàn hảo");
        int kiemTra = scanner8.nextInt();

        ArrayList<Integer> mangUocSo = new ArrayList<>();

        for (int i = 1; i < kiemTra; i++) {
            if (kiemTra % i == 0) {
                mangUocSo.add(i);
            }
        }

        int tongUocSo = 0;
        for (int num : mangUocSo) {
            tongUocSo += num;
        }

        if (kiemTra == tongUocSo) {
            System.out.println("Số kiểm tra có tính hoàn hảo");
        } else {
            System.out.println("Số kiểm tra không có tính hoàn hảo");
        }
    }

    public static void Bai9() {
        Scanner scanner9 = new Scanner(System.in);

        // Nhập 3 số a, b, c
        System.out.print("Nhập số a: ");
        double a = scanner9.nextDouble();
        System.out.print("Nhập số b: ");
        double b = scanner9.nextDouble();
        System.out.print("Nhập số c: ");
        double c = scanner9.nextDouble();

        // Tính delta
        double deltaValue = b * b - 4 * a * c;

        // Tìm nghiệm dựa theo giá trị delta
        if (deltaValue > 0) {
            // 2 nghiệm riêng biệt
            double x1 = (-b + Math.sqrt(deltaValue)) / (2 * a);
            double x2 = (-b - Math.sqrt(deltaValue)) / (2 * a);
            System.out.println("Phương trình có 2 nghiệm riêng biệt: " + x1 + " và " + x2);
        } else if (deltaValue == 0) {
            // Một nghiệm chung
            double x = -b / (2 * a);
            System.out.println("Phương trình có một nghiệm chung: " + x);
        } else {
            System.out.println("Phương trình không có nghiệm.");
        }
    }

    public static void Bai10() {
        Scanner scanner10 = new Scanner(System.in);
        System.out.print("Nhập số tiền cần rút: ");
        double soTienCanRut = scanner10.nextDouble();

        ArrayList<Integer> cacLoaiMenhGiaTien = new ArrayList<>(Arrays.asList(500, 200, 100, 50, 20, 10, 5, 2, 1));
        HashMap<String, Integer> bangTien = new HashMap<>();

        // Kiểm tra từ mệnh giá cao nhất đến mệnh giá thấp nhất để tối thiểu số tờ tiền cần rút
        for (int i = 0; i < cacLoaiMenhGiaTien.size() - 1; i++) {
            while (soTienCanRut >= cacLoaiMenhGiaTien.get(i)) {
                soTienCanRut -= cacLoaiMenhGiaTien.get(i);
                if (!bangTien.containsKey(String.valueOf(cacLoaiMenhGiaTien.get(i)))) {
                    bangTien.put(String.valueOf(cacLoaiMenhGiaTien.get(i)), 1);
                } else {
                    bangTien.put(String.valueOf(cacLoaiMenhGiaTien.get(i)), bangTien.get(String.valueOf(cacLoaiMenhGiaTien.get(i))) + 1);
                }
            }
        }

        int tongSoToTien = 0;
        for (String menhGiaTien : bangTien.keySet()) {
            System.out.println("Mệnh giá: " + menhGiaTien + " Số tờ đã rút: " + bangTien.get(menhGiaTien));
            tongSoToTien += bangTien.get(menhGiaTien);
        }
        System.out.println("Số tờ tiền cần rút: " + tongSoToTien);
    }

}

