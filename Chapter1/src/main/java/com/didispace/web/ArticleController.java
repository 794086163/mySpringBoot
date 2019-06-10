package com.didispace.web;

import com.didispace.domin.p.UserRepository;
import com.didispace.domin.s.MessageRepository;
import com.didispace.entity.Article;
import com.didispace.entity.Test;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Resful风格的代码（post,delete,get,put增删查改）
 * @author v-yangxu
 *
 */
@RestController
@RequestMapping(value="/article/" )
@Log4j
public class ArticleController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;
	
//	@Autowired
//	private StudentRepository studentRepository;

	private static Map<String,Article> ArticleMap=Collections.synchronizedMap(new HashMap<String,Article>()); 

	@ApiOperation(value="添加文章",notes="test添加文章")
	@ApiImplicitParam(name="article",value="文章实体article",required=true,dataType="Article")
	@PostMapping("addArticle")
	//此时需要添加@RequestBody来获取实体对象
	public Test addArticle(@RequestBody Article article){
		ArticleMap.put(""+(ArticleMap.size()+1), article);
		Test test=new Test();
		test.setArticleMap(ArticleMap);
		return test;
	}
	
	@ApiOperation(value="获取文章列表",notes="获取全部文章")
	@GetMapping(value="getArticles")
	public Test getArticles(){
		Test test=new Test();
		test.setArticleMap(ArticleMap);
		log.info("数据："+test);
		return test;
	}
	
	/*
	 * paramType必须填写才能删除
	 * path	以地址的形式提交数据
	 * query 直接跟参数完成自动映射赋值
	   body	以流的形式提交 仅支持POST
	   header 参数在request headers 里边提交
       form	以form表单的形式提交 仅支持POST
	 */
	@ApiOperation(value="删除文章", notes="根据url的id来删除文章")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true, dataType = "String",paramType = "path")
	@DeleteMapping(value="deleteArticle/{id}")
	public Test deleteArticle(@PathVariable(value = "id") String id){
		ArticleMap.remove(id);
		Test test=new Test();
		test.setArticleMap(ArticleMap);
		return test;
	}
	
	@ApiOperation(value="更新文章细信息", notes="根据url的id来指定更新对象，并根据传过来的article信息来更新文章详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "文章ID", required = true, dataType = "String",paramType="path"),
            @ApiImplicitParam(name = "article", value = "文章详细实体article", required = true, dataType = "Article")
    })
	@PutMapping(value="updateArticle/{id}")
	/*
	 * 传入的实体类必须使用@RequestBody
	 */
	public Test updateArticle(@PathVariable(value = "id") String id, @RequestBody Article article){
		ArticleMap.put(id, article);
		Test test=new Test();
		test.setArticleMap(ArticleMap);
		return test;
	}
	
	@GetMapping("listAllUsers")
	public Object listAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("listAllMessage")
	public Object listAllMessage(){
		return messageRepository.findAll();
	}
}
