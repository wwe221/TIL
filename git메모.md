# git

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

# Git Branch

Branch 를 통한 코드 관리

CI & CD
Git의 Master brancn 에 새로운 commit 이 생기면 `자동으로`프로젝트를 메인서버에 올리고 메인서비스에 적용이 되게끔 구현해 놓은 기능

때문에 아무나 Master Branch에 push 할 수 없게끔 권한을 줘야 한다.

## Branch

각각의 가지(branch) 는 서로 독립적이기 때문에 간섭할 수 없다.
기본적으로 만들어 지는 brach를 master라 한다.

### 명령어

`git branch` 현재 branch 의 상태 ( 어떤 브랜치가 있는지, 내가 어떤 브랜치 인지) 확인

`git branch [브랜치이름]` 새로운 브랜치 생성

`git switch [브랜치이름]` 브랜치 이동

`git merge [브랜치이름]` 현재 브랜치에서 해당 브랜치를 가져와 합친다.

`git branch -d [브랜치이름] ` 브랜치 삭제

`git checkout -b [브랜치이름]` 브랜치를 생성하고 이동 == `git switch -c [브랜치이름]`

`gti branch -r 원격 저장소에 있는 branch 확인`

`git checkout -t origin/[브랜치 이름]`

# Merge Scenario

1. Fast Forward Merge - 기존의 브랜치에 더 이상 수정 사항이 없을 경우 기존 브랜치의 Pointer 만 옮겨도 무방한 경우
2. Auto Merge (Merge without Conflict) - 두 브랜치의 수정 파일이 겹치지 않는 경우 ( 충돌 conflict 가 없는 경우)
3. Merge With Conflict - 두 브랜치의 수정된 파일이 겹치는 경우, conflict 가 발생하고 이를 해결 해야만 merge가 성공적으로 이루어 질 수 있다.