# helloDI

## What is DI
- DI(Dependency Injection)  
-프로그래밍에서 구성요소 간의 의존 관계가 소스코드 내부가 아닌 외부의 설정파일을 통해 정의되는 방식  
-코드 재사용을 높여 소스코드를 다양한 곳에 사용할 수 있으며 모듈간의 결합도도 낮춤  
-계층, 서비스 간에 의존성이 존재하는 경우 스프링 프레임워크가 서로 연결시켜줌
-XML, annotation, Java-based Configuration으로 설정

## Spring Container
- Spring Container에 의해 bean에 의존성을 주입한다
  1. Create Beans : 빈 생성
  2. wire them together : 의존성 주입
  3. configure them : 빈을 설정
  4. manage their complete lifecycle : 빈의 life cycle 관리(생성, 제거)

- BeanFactory
  - 리소스가 제한된 환경에서 사용한다. ex) mobile, applets

- ApplicationContext
  - 대부분의 환경에서 사용한다.
  
  ```java
    // Conatiner 생성
    // XML 파일 보고 bean 생성
    // 연관관계 연결
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/spring/di/conf/anmial.xml");  
    
    PetOwner person = (PetOwner) context.getBean("id_petOwner"); // id_petOwner 는 id 값
    ```
    
## XML 사용

- animal.xml
```xml
<!-- scope를 따로 지정하지 않으면 모두 singleton으로 객체 생성  -->

<!-- constructor로 주입 -->
<bean id="id_dog" class="kr.ac.hansung.spring.di.Dog">
  <constructor-arg value="poodle" />
  <qualifier value="qf_dog"></qualifier>
</bean>

<!-- setter로 주입 -->
<bean id="id_cat" class="kr.ac.hansung.spring.di.Cat">
  <property name="myName" value="bella"></property>
  <qualifier value="qf_cat"></qualifier>
</bean>

<!-- 생성자로로 주입. petOwner class에서 @RequiredArgsConstructor 해줫기 때문에 -->
<bean id="id_petOwner" class="kr.ac.hansung.spring.di.PetOwner"></bean>

<!-- anotation기능 활성화 -->
<context:annotation-config></context:annotation-config>
```

- Main.java

```java
 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("kr/ac/hansung/spring/di/conf/anmial.xml");  
  
 PetOwner person = (PetOwner) context.getBean("id_petOwner"); // id_petOwner 는 id 값
 person.play();
```

- 위의 코드와 같이 Main에서는 의존성 주입만 되었기 때문에 java 코드에서 해당 객체의 값이 무엇인지 상관이 없으며 xml의 설정만 바꾸어 주면 어떤 값(강아지던지, 고양이던지)이던 상관이 없다.  
- 의존성 주입은 setter로 할 수도 있고, Constructor로도 해줄 수 있다.


## Annotation 사용
- xml이 길어서 Annotation을 사용하기도 한다.
- xml과 annotation 둘다 사용중이라면 xml이 annotation을 override 한다.
- xml에 annotation을 활성화해주어야한다.

```xml
<context:annotation-config></context:annotation-config>
```
### @Required
![1](https://user-images.githubusercontent.com/32935365/62724600-5226ca00-ba4e-11e9-81bf-5bee22ba509e.PNG)  

### @Autowired
![2](https://user-images.githubusercontent.com/32935365/62724635-666ac700-ba4e-11e9-8a8a-ad7caea7fd85.PNG)

### @Qualifier
![3](https://user-images.githubusercontent.com/32935365/62724710-89957680-ba4e-11e9-9482-e0d506eb7a3e.PNG)

### @Resource
![4](https://user-images.githubusercontent.com/32935365/62724716-9023ee00-ba4e-11e9-9e12-66c808acee46.PNG)
