package edu.persistence.model;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BookTest
{

   @Inject
   private Book book;

   @Deployment
   public static Archive createDeployment()
   {
      return ShrinkWrap.create(WebArchive.class, "book-test.war")
              .addPackages(true, "edu.persistence")
              .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
              .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Test
   public void should_be_deployed()
   {
      Assert.assertNotNull(book);
   }
}
