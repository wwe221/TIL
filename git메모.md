# git 기초 입니당

### 코드 관리
    SCM
        Source Code Management
    VCS
        Version Control System    

    Working Direcory
        Staging Area   
            Commiting

### 헙업도구
-   push & pull
-   forking & pull request (github flow)

Hash 를 이용해서 파일의 내용 변경을 추적한다.

Git 기초 커맨드
## 기본커맨드
`git init` git repository 시작 ( .git 생성)

`git status` git 상태확인

`git add` 파일을 Staging Area 에 올리기

`git commit -m "[메세지]" ` : commit

`git log` : commit history 확인하기

## 추가커맨드

`git checkout [commitHash]` 특정 커밋 확인하기

`git checkout master` 현재 버전으로 돌아오기

`git restore [FileName]` 파일을 최근 커밋으로 되돌리기 ( 추가 내용을 버릴 때)    


## 원격 저장소 관리

`git remote -v ` 원격저장소 정보 상세

`git remote add [원격저장소이름] [원격저장소 주소] ` 원격저장소 추가

`git push [원격저장소이름] [브랜치 이름]` 원격저장소에 업데이트

`git clone [원격저장소 주소] [프로젝트 이름(생략가능)]` 원격저장소 복제

`git pull [저장소이름] [브랜치 이름] `  로컬저장소 업데이트

## 오픈소스 개발 참여하기
Fork 를 통해서 repository를 가져온다.

수정한 내용을 자신의 repository 에 push 한다.

Owner 에게 pull request를 보낸다.
