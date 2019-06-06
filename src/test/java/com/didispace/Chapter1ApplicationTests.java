package com.didispace;

import com.didispace.domin.p.User;
import com.didispace.domin.p.UserRepository;
import com.didispace.domin.s.MessageRepository;
import com.didispace.domin.s.MessageTest;
import com.didispace.ldap.Person;
import com.didispace.ldap.PersonRepository;
import com.didispace.mongodb.UserDao;
import com.didispace.mybatis.UserMapper;
import com.didispace.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.jboss.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Log4j2
public class Chapter1ApplicationTests {

    private MockMvc mvc;

    @Autowired
    private UserService userSerivce;

    //	@Autowired
//	private StudentRepository studentRepository;
//
//	
//	
//	@Test
//	public void testRepository(){
//		Student s=new Student();
//		s.setName("一er");
//		s.setAge(12);
////		studentRepository.save(s);
//		studentRepository.deleteById(8L);
//		System.out.println(studentRepository.findAll());
//		
//	}
//	
    @Test
    public void test1() throws Exception {
        System.out.println(userSerivce.listAllT1());
//		System.out.println(userSerivce.listAllT2());
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Before
    public void setUp() {
    }

    @Test
    public void test() throws Exception {

        userRepository.save(new User("aaa", 10));
        userRepository.save(new User("bbb", 20));
        userRepository.save(new User("ccc", 30));
        userRepository.save(new User("ddd", 40));
        userRepository.save(new User("eee", 50));

//		Assert.assertEquals(5, userRepository.findAll().size());
        System.out.println(userRepository.findAll().size());
        messageRepository.save(new MessageTest("o1", "aaaaaaaaaa"));
        messageRepository.save(new MessageTest("o2", "bbbbbbbbbb"));
        messageRepository.save(new MessageTest("o3", "cccccccccc"));
        System.out.println(messageRepository.findAll().size());
//		Assert.assertEquals(3, messageRepository.findAll().size());

    }

    @Autowired
    private StringRedisTemplate stringT;

    @Test
    public void redisTest() {
        stringT.opsForValue().set("海扁王", "20");
        System.out.println(stringT.opsForValue().get("海扁王"));

    }

    @Autowired
    private UserDao userdao;

    @Test
    public void mongodbTest() {
        com.didispace.mongodb.User u = new com.didispace.mongodb.User();
        u.setId(2L);
        u.setUsername("zhangs");
        u.setAge(18);
        userdao.save(u);
//		userdao.delete(3L);
        u.setAge(999);
        userdao.update(u);
        System.out.println(userdao.findAll());
    }

    @Autowired
    private UserMapper mapper;

    @Test
    public void mybatisTest() {
        User user = new User();
        user.setAge(9);
        user.setName("oo");
//		mapper.insert(user.getName(),user.getAge());
        mapper.update(user);
        System.out.println(mapper.findAll());
    }

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void ldapTest() {
        personRepository.findAll().forEach((p) -> {
            System.out.println("输出：" + p);
        });
        System.out.println(personRepository.findAll().toString());
        Person person = new Person();
        person.setUid("uid:1");
        person.setSureName("AAA");
        person.setCommonName("aaa");
        person.setUserPassword("123456");
        personRepository.save(person);

        personRepository.findAll().forEach((p) -> {
            System.out.println(p);
        });
    }

//	@Before
//	public void dAll(){
//		userRepository.save(new User("b",1));
//	}

    @Test
//	@Transactional
    public void validaJpaTest() {
        userRepository.save(new User("a", 1));
        userRepository.save(new User("b", 1));
        userRepository.save(new User("cc", 1));
        userRepository.save(new User("c", 1));

//		System.out.println(userRepository.findAll().size());
//		System.out.println(userRepository.findByName("a"));
//		System.out.println(userRepository.findUserByName("c"));
    }

    @Autowired
    private CacheManager cacheManager;


    @Test
    public void ecacheTest() {

        User t1 = userRepository.findByName("b");
        System.out.println("第一次查询：" + t1);
        User t2 = userRepository.findByName("b");
        System.out.println("第二次查询：" + t2);
        t2.setAge(99999);
        userRepository.save(t2);
        User t3 = userRepository.findByName("b");
        System.out.println("第三次次查询：" + t3);
        System.out.println(cacheManager.getCache("users"));
//		System.out.println(userRepository.findByName("a"));
//		System.out.println(userRepository.findUserByName("c"));
        System.out.println(cacheManager.getCacheNames());
    }

    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void logTest() {
        logger.info("托尔斯泰1");
//		logger.debug("托尔斯泰1");
//		logger.error("托尔斯泰1");
        System.out.println("test");
    }

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("794086163@qq.com");
        simpleMailMessage.setTo("v-yangxu@meizu.com");
        simpleMailMessage.setSubject("主题，简单邮件");
        simpleMailMessage.setText("测试邮件内容");
        mailSender.send(simpleMailMessage);
    }

    @Test
    public void sendAttachmentsMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("794086163@qq.com");
        helper.setTo("v-yangxu@meizu.com");
        helper.setSubject("有附件的邮件");
        helper.setText("测试有附件的邮件");

        FileSystemResource fileSystemResource = new FileSystemResource(new File("C:/Users/v-yangxu/Desktop/权限系统对外接口说明2018-03-02.xlsx"));
        helper.addAttachment("附件1.xlsx", fileSystemResource);
        helper.addAttachment("附件2.xlsx", fileSystemResource);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendInlineMail(){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom("794086163@qq.com");
            helper.setTo("v-yangxu@meizu.com");
            helper.setSubject("嵌入静态资源邮件");
            helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

            FileSystemResource fileSystemResource=new FileSystemResource(new File("C:/Users/v-yangxu/Desktop/B4E15E5D-A072-4aef-AFD9-C16DA5DFB0C0.png"));
            helper.addInline("weixin",fileSystemResource);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }




}

