package io.simpolor.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

    private static List<String> firstName = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권", "황", "안",
            "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽", "성", "차", "주",
            "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현", "함", "변", "염", "양",
            "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표", "명", "기", "반", "왕", "금",
            "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구", "용");

    private static List<String> lastName = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노", "누", "다",
            "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미", "민", "바", "박",
            "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소", "솔", "수", "숙", "순",
            "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요", "용", "우", "원", "월", "위",
            "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전", "정", "제", "조", "종", "주", "준",
            "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택", "판", "하", "한", "해", "혁", "현", "형",
            "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부", "림", "봉", "혼", "황", "량", "린", "을", "비",
            "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱", "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼",
            "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식", "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠",
            "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개", "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");

    private static List<String> hobby = Arrays.asList("골프", "낚시", "당구", "클라이밍", "등산", "사격", "사냥", "승마", "스킨스쿠버", "자전거", "캠핑",
            "스노우보드", "마라톤", "서핑", "쇼핑", "게임", "정리", "조경", "맛집투어", "도박", "레이싱", "드라이브", "자동차 튜닝", "출사", "렌즈수집", "커피", "우표수집",
            "수조", "원예", "분재", "곤충", "프라모델", "얼리어답터", "음반", "피규어", "미니어쳐", "천체관측", "골동품", "도자기", "키보드", "미술관람", "증권", "주식",
            "검도", "유도", "태권도", "축구", "만화", "DIY", "뜨개질", "프로그래밍", "서예", "헬스", "조깅", "수영", "필라테스", "요가", "배드민턴", "테니스", "볼링",
            "농구", "장기", "바둑", "체스", "크로스핏", "사우나", "소설", "수다", "복권", "경마");

    public static String generateName(){
        Random random = new Random();
        return firstName.get(random.nextInt(firstName.size())) + lastName.get(random.nextInt(lastName.size())) + lastName.get(random.nextInt(lastName.size()));
    }

    public static int generateAge(){
        return (int)(Math.random() * (50 - 20 + 1) + 20);
    }

    public static String generateHobby(){
        Random random = new Random();
        return hobby.get(random.nextInt(hobby.size()));
    }

}
