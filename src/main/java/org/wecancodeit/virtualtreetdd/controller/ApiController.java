package org.wecancodeit.virtualtreetdd.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.virtualtreetdd.entity.Bean;
import org.wecancodeit.virtualtreetdd.entity.Branch;
import org.wecancodeit.virtualtreetdd.entity.Cluster;
import org.wecancodeit.virtualtreetdd.entity.VirtualTree;
import org.wecancodeit.virtualtreetdd.repository.BeanRepository;
import org.wecancodeit.virtualtreetdd.repository.BranchRepository;
import org.wecancodeit.virtualtreetdd.repository.ClusterRepository;
import org.wecancodeit.virtualtreetdd.repository.VirtualTreeRepository;

@RestController
@RequestMapping("/api")
public class ApiController {
  @Autowired VirtualTreeRepository vTreeRepo;

  @Autowired BranchRepository branchRepo;

  @Autowired ClusterRepository clusterRepo;

  @Autowired BeanRepository beanRepo;

  @RequestMapping(value = "/virtualtrees", method = RequestMethod.GET)
  public Collection<VirtualTree> getVirtualTrees() {

    return (Collection<VirtualTree>) vTreeRepo.findAll();
  }

  @RequestMapping(value = "/virtualtrees/{treeId}/branches", method = RequestMethod.GET)
  public Collection<Branch> getBranches(@PathVariable(name = "treeId") Long treeId) {

    return vTreeRepo.findOne(treeId).getBranches();
  }

  @RequestMapping(
      value = "/virtualtrees/{treeId}/branches/{branchId}/clusters",
      method = RequestMethod.GET)
  public Collection<Cluster> getClusters(
      @PathVariable(name = "treeId") Long treeId, @PathVariable(name = "branchId") Long branchId) {

    return branchRepo.findOne(branchId).getClusters();
  }

  @RequestMapping(
      value = "/virtualtrees/{treeId}/branches/{branchId}/clusters/{clusterId}/beans",
      method = RequestMethod.GET)
  public Collection<Bean> getBeans(
      @PathVariable(name = "treeId") Long treeId,
      @PathVariable(name = "branchId") Long branchId,
      @PathVariable(name = "clusterId") Long clusterId) {

    return clusterRepo.findOne(clusterId).getBeans();
  }

  @RequestMapping(
      value = "/virtualtrees/{treeId}/branches/{branchId}/clusters/{clusterId}/beans/{beanId}",
      method = RequestMethod.GET)
  public Bean getBean(
      @PathVariable(name = "treeId") Long treeId,
      @PathVariable(name = "branchId") Long branchId,
      @PathVariable(name = "clusterId") Long clusterId,
      @PathVariable(name = "beanId") Long beanId) {

    return beanRepo.findOne(beanId);
  }

  @RequestMapping(value = "/beans/{beanId}", method = RequestMethod.GET)
  public Bean getBean(@PathVariable(name = "beanId") Long beanId) {
    return beanRepo.findOne(beanId);
  }

  @RequestMapping(value = "/beans/{beanId}/checkanswer", method = RequestMethod.GET)
  public boolean checkAnswerOfBean(
      @PathVariable(name = "beanId") Long beanId,
      @RequestParam(value = "answerToCheck") String answerToCheck) {

    String correctAnswer = beanRepo.findOne(beanId).getCorrectAnswer();
    if (!correctAnswer.equalsIgnoreCase(answerToCheck.trim())) {
      return false;
    } else {
      beanRepo.findOne(beanId).setCompletedQuestion();
    }
    return true;
  }

  @RequestMapping(value = "/clusters/{clusterId}/getnextbean", method = RequestMethod.GET)
  public Bean getNextBean(
      @PathVariable(name = "clusterId") Long clusterId,
      @RequestParam(value = "currentBeanQuestionNum") int currentBeanQuestionNum) {
    Cluster currentCluster = clusterRepo.findOne(clusterId);
    return currentCluster.getBean(currentBeanQuestionNum + 1);
  }

  @RequestMapping(value = "/clusters/{clusterId}/checkBean", method = RequestMethod.GET)
  public boolean checkIfBeanIsLastInCluster(
      @PathVariable(name = "clusterId") Long clusterId,
      @RequestParam(value = "beanId") Long beanId) {

    Cluster cluster = clusterRepo.findOne(clusterId);
    if (!cluster.isLastBean(beanRepo.findOne(beanId))) {
      return false;
    }
    return true;
  }

  @RequestMapping(value = "/clusters/{clusterId}/getNextCluster", method = RequestMethod.GET)
  public Cluster getNextCluster(@PathVariable(name = "clusterId") Long clusterId) {
    return clusterRepo.findOne(clusterId + 1L);
  }
}