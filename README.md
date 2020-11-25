<h1 align="left">Info Movies (Kotlin dagger-hilt)</h1>

<p align="left">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=20"><img alt="API" src="https://img.shields.io/badge/API-20%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://jroomstudio.tistory.com/"><img alt="Medium" src="https://img.shields.io/badge/blog-tistory-green"/></a>
  <a href="https://github.com/jrooms"><img alt="Profile" src="https://img.shields.io/badge/github-jrooms-orange?logo=github&logoColor=white"/></a> 
</p>

<p align="left">  
<img src="/readme/info_01.png" width="250" height="500"/>
<img src="/readme/info_02.png" width="250" height="500"/>
<img src="/readme/info_03.png" width="250" height="500"/>
</p>
</br>

## Referenced Project
<p align="left">
  <a href="https://github.com/skydoves/Pokedex"><img alt="Pokedex" src="/readme/pokedex.png"/></a>
</p>
</br>

## Architecture
![architecture](https://developer.android.com/codelabs/android-room-with-a-view-kotlin/img/a7da8f5ea91bac52.png)
</br>
</br>

## Open API 
[The Movie Database](https://www.themoviedb.org/)    
local.properties에 api-key를 추가하세요.    
```
movie_api_key="add your api key"
```
</br>

## Blog Post
해당 프로젝트는 dagger-hilt를 학습하기 위해 작성되었습니다.   
dagger-hilt를 학습하시는 분들께 작은 도움이라도 되고자 참고한 프로젝트를 분석하고 구현하면서 공부했던 주요 내용들을 블로그에 정리해 두었습니다.   
[Android Dagger-Hilt (1) - Dependency Injection](https://jroomstudio.tistory.com/47?category=437501)    
[Android Dagger-Hilt (2) - Local Database](https://jroomstudio.tistory.com/48?category=437501)    
[Android Dagger-Hilt (3) - Network](https://jroomstudio.tistory.com/53?category=437501)    
[Android Dagger-Hilt (4) - MVVM](https://jroomstudio.tistory.com/55?category=437501)    
[Android Dagger-Hilt (5) - Repositoy](https://jroomstudio.tistory.com/56?category=437501)    
[Android Dagger-Hilt (6) - ViewModel + Repository(Sandwich)](https://jroomstudio.tistory.com/58?category=437501)
</br>
</br>

<img src="/readme/info_04.gif" align="right" width="30%"/>

## 사용기술 및 라이브러리
- Minimum SDK level 20
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt (alpha) for dependency injection.
- JetPack
  - LiveData
  - Lifecycle
  - ViewModel
  - Room Database
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - Repository pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit)
- [Sandwich](https://github.com/skydoves/Sandwich)
- [Gson](https://github.com/google/gson)
- [Moshi](https://github.com/square/moshi)
- [Glide](https://github.com/bumptech/glide)
- [WhatIf](https://github.com/skydoves/whatif)
- [Material-Components](https://github.com/material-components/material-components-android)
</br>
</br>

```
Copyright by 2020 skydoves (Jaewoong Eum)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
