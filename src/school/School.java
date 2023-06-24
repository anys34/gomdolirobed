package school;

import student.Student;

import java.util.ArrayList;

public class School {
    static ArrayList<Student> studentsData = new ArrayList<>();

    // 제출 내용 저장
    public static void submit(ArrayList<Student> obj) {
        if (obj != null) studentsData.addAll(obj); // 데이터가 포함 되어 있으면 저장
    }

    // 점수 순으로 출력
    public static void search() {
        studentsData.sort((student1, student2) -> Integer.compare(student2.getScore(), student1.getScore()));
        for(Student student : studentsData) {
            System.out.println(student);
        }
    }

    // 합불 여부 처리
    public static void pass() {
        for (Student student : studentsData) {
            // 합격 기준 : / 성적 80% / 출결 10% / 가산점 10% /
            if (student.getScore() * 0.8 + student.getAttendance() + student.getPoint() >= 70)
                student.setPass(true);
        }
    }

    // 본인의 원서 조회
    public static void check(String name) {
        studentsData.stream()
                .filter(student -> name.equals(student.getName()))
                .forEach(student -> {
                    System.out.println("==================================");
                    System.out.println(student.getName() + "의 원서접수 내용");
                    System.out.println("==================================");
                    System.out.println("지원자 이름 : " + student.getName());
                    System.out.println("전화번호 : " + student.getTel());
                    System.out.println("출신 중학교 : " + student.getNativeSC());
                    System.out.println("성적 : " + student.getScore());
                    System.out.println("출결 : " + student.getAttendance());
                    System.out.println("가산점 : " + student.getPoint());
                    System.out.println("지원자의 합격 여부 : " + student.isPass());
                });
    }
}
