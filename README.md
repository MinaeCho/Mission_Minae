### SpringBoot-Project-Board

## 프로젝트 소개
댓글쓰기가 존재하는 게시판입니다.

## 개발 기간
24.1.8 ~ 24.1.11

## 멤버 구성
개인 프로젝트

## 개발 환경
```Java 21```

Framework: Springboot(3.2.1)

Database: SQLite

ORM: JPA

## 주요 기능
게시판 기능

게시글 기능

댓글 기능

## 요구 사항
### 1. 게시판 기능

- 게시판은 같은 주제의 게시글을 모아둔 단위를 의미한다.
- 게시판의 목록과, 선택된 게시판의 게시글 목록을 볼 수 있는 화면이 필요하다.
    - 게시판 목록의 링크를 선택하면, 해당 게시판에 작성된 게시글 제목만 목록으로 출력되는 화면으로 이동한다.
    - 또한 전체 게시글을 위한 전체 게시판이 존재한다.
    - 게시글 제목은 링크로, 해당 게시글의 정보를 전부 조회할 수 있는 페이지로 이동된다.
    - 조회되는 게시글들은 항상 나중에 작성된 게시글이 최상단에 작성된다.
- 자유 게시판, 개발 게시판, 일상 게시판, 사건사고 게시판이 존재한다.

### 2. 게시글 기능

- 게시글은 하나의 주제에 대한 의견을 교환하기 위한 글을 의미한다.
    - 제목, 내용으로 구성되어 있다.
    - 게시글이 작성되는 게시판이 존재한다.
- 게시글을 작성할 수 있다.
    - 게시글을 작성하는 페이지가 필요하다.
    - 게시글을 작성하는 페이지에서 어떤 게시판에 작성할지를 선택 가능하다.
    - 게시글의 제목과 내용을 작성한다.
    - 게시글의 내용 자체는 Plain Text로만 구성된다.
    - 게시글을 작성할때는 작성자가 자신임을 증명할 수 있는 비밀번호를 추가해서 작성한다.
- 게시글 단일 조회 화면이 필요하다.
    - 댓글과 관련된 기능은 이 화면에 포함된다.
        - 댓글 목록
        - 댓글 추가하기
        - 댓글 삭제하기
    - 게시글 삭제를 위한 UI가 여기 존재한다.
- 게시글을 수정할 수 있다.
    - 게시글을 수정하는 페이지가 필요하다.
    - 게시글을 수정하는 페이지에는, 게시글의 본래 제목, 글이 존재한다.
    - 게시글 수정을 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 게시글 작성 당시의 비밀번호와 일치해야 실제로 수정이 이뤄진다.
- 게시글을 삭제할 수 있다.
    - 단일 게시글 조회 페이지에 있는 삭제를 위한 UI를 이용해 삭제한다.
    - 게시글 삭제를 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 게시글 작성 당시의 비밀번호와 일치해야 실제로 삭제가 이뤄진다.
     
### 3. 댓글 기능

- 댓글을 작성할 수 있다.
    - 댓글의 작성은 게시글 단일 조회 페이지에서 이뤄진다.
    - 댓글을 작성할때는 작성자가 자신임을 증명할 수 있는 비밀번호를 추가해서 작성한다.
- 댓글의 목록은 게시글 단일 조회 페이지에서 확인이 가능하다.
- 댓글의 삭제는 게시글 단일 조회 페이지에서 가능하다.
    - 댓글 삭제를 하기 위한 UI가 존재해야 한다.
    - 댓글 삭제를 위해 비밀번호를 제출할 수 있어야 한다.
        - 이 비밀번호가 댓글 작성 당시의 비밀번호와 일치해야 실제로 삭제가 이뤄진다.

## 테이블 설계
<img width="902" alt="Screenshot 2024-01-11 at 2 42 15 PM" src="https://github.com/MinaeCho/Mission_Minae/assets/151011576/77ae4669-4734-4aa3-a7f3-ec51dd2730a4">

## 화면 설계
### 게시판
![Screenshot 2024-01-11 at 2 46 00 PM (2)](https://github.com/MinaeCho/Mission_Minae/assets/151011576/c9a0abe1-f0c3-4e4a-b520-c27d32c7d0cd)
1. 게시판 목록을 볼 수 있는 화면
2. 해당 게시판을 클릭하면 해당 게시판으로 이동한다.

![Screenshot 2024-01-11 at 2 58 57 PM (2)](https://github.com/MinaeCho/Mission_Minae/assets/151011576/c51846de-a707-4b42-bf1c-086880efb693)
1. 해당 게시판의 게시글 목록을 볼 수 있는 화면
2. 글 등록 클릭시 게시글을 작성할 수 있는 화면으로 이동한다.

### 게시글
![Screenshot 2024-01-11 at 2 54 26 PM (2)](https://github.com/MinaeCho/Mission_Minae/assets/151011576/6452b6b7-2592-4f99-8ca3-366d3ce0f71f)
1. 게시글을 작성하는 화면
2. 제목과 내용으로 이루어져있다. (댓글 삭제때 본인인증을 위한 비밀번호칸도 있으나 코드를 구현하지 못하였다.)
3. 해당 페이지에서 게시판의 종류를 선택할 수 있다.
4. 제출을 누르면 게시글목록을 볼 수 있는 페이지로 이동한다.
<img width="1042" alt="Screenshot 2024-01-11 at 3 15 39 PM" src="https://github.com/MinaeCho/Mission_Minae/assets/151011576/9b99aacc-1107-4771-aa3e-3db46c2f1540">
1. 게시글 제목을 누르면 해당 게시글의 상세페이지로 이동한다.
2. 게시판 유형에서 게시판을 선택하면 해당 게시판으로 이동한다. (코드가 이상한지 오류가 날 때가 있다.--수정 필요)
   
![Screenshot 2024-01-11 at 3 18 58 PM (2)](https://github.com/MinaeCho/Mission_Minae/assets/151011576/4a648c63-d37d-4e5c-9ef8-776b33a1ad49)
1. 글의 상세내용을 볼 수 있는 화면
2. '수정' 클릭시 게시글의 수정 화면으로 이동한다. (수정페이지의 css는 아직 정리를 못하였다.)
3. '삭제' 클릭시 해당 게시글이 삭제된다.
4. 해당 페이지에서 댓글을 작성할 수 있다.
5. 댓글 작성완료시 댓글 목록에 해당 댓글이 나타난다.

### 댓글
 ![Screenshot 2024-01-11 at 3 21 29 PM (2)](https://github.com/MinaeCho/Mission_Minae/assets/151011576/509147eb-27e5-4933-8d95-38e2d5dd3461)
1. '삭제'클릭시 해당 댓글이 삭제된다.

## 어려웠던 점 & 보안할 점
1. 게시판의 종류가 다양하다는 것을 인지하지 못하고 코드를 짜기 시작해서 나중에 코드가 꼬였다. -> 다음에 프로젝트를 진행할 때는 테이블을 꼭 먼저 설계하고 작성하기!!
2. css부분이 아직 익숙지않은데 같이 생각하면서 작업을 하려니 힘들었다. -> html과 css공부도 더 열심히 하자.
3. entity간의 관계 설정이 어려웠다. 전반적으로 코드에 대한 공부 더 열심히 하자.

