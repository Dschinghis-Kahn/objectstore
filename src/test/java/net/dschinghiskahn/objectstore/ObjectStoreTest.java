package net.dschinghiskahn.objectstore;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ObjectStoreTest {

    private static final int MULTIPLE_TEST_SIZE = 1050;

    @BeforeClass
    public static void init() {
    }

    @Test(timeout = 1000)
    public void singleString() {
        LogManager.getLogger(getClass()).info("Running test: singleString()");
        String testObject = "test";
        ObjectStore<String> objectStore = new ObjectStore<String>();
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        objectStore.add(testObject);
        Assert.assertEquals(1, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        Assert.assertEquals(objectStore.get(), testObject);
    }

    @Test(timeout = 1000)
    public void multipleStrings() {
    	LogManager.getLogger(getClass()).info("Running test: multipleStrings()");
        String testObject = "test";
        ObjectStore<String> objectStore = new ObjectStore<String>(ObjectStoreTest.MULTIPLE_TEST_SIZE);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            objectStore.add(testObject + i);
        }
        Assert.assertEquals(ObjectStoreTest.MULTIPLE_TEST_SIZE, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            Assert.assertEquals(objectStore.get(), testObject + i);
        }
    }

    @Test(timeout = 1000)
    public void singleObject() {
    	LogManager.getLogger(getClass()).info("Running test: singleObject()");
        Object testObject = new Object();
        ObjectStore<Object> objectStore = new ObjectStore<Object>();
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        objectStore.add(testObject);
        Assert.assertEquals(1, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        Assert.assertEquals(objectStore.get(), testObject);
    }

    @Test(timeout = 1000)
    public void multipleObjects() {
    	LogManager.getLogger(getClass()).info("Running test: multipleObjects()");
        Object testObject = new Object();
        ObjectStore<Object> objectStore = new ObjectStore<Object>(ObjectStoreTest.MULTIPLE_TEST_SIZE);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            objectStore.add(testObject);
        }
        Assert.assertEquals(ObjectStoreTest.MULTIPLE_TEST_SIZE, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            Assert.assertEquals(objectStore.get(), testObject);
        }
    }

    @Test(timeout = 1000)
    public void singleInteger() {
    	LogManager.getLogger(getClass()).info("Running test: singleInteger()");
        Integer testObject = 12346234;
        ObjectStore<Integer> objectStore = new ObjectStore<Integer>();
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        objectStore.add(testObject);
        Assert.assertEquals(1, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        Assert.assertEquals(objectStore.get(), testObject);
    }

    @Test(timeout = 1000)
    public void multipleIntegers() {
        LogManager.getLogger(getClass()).info("Running test: multipleIntegers()");
        Integer testObject = 0;
        ObjectStore<Integer> objectStore = new ObjectStore<Integer>(ObjectStoreTest.MULTIPLE_TEST_SIZE);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            objectStore.add(testObject + i);
        }
        Assert.assertEquals(ObjectStoreTest.MULTIPLE_TEST_SIZE, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            Assert.assertEquals(objectStore.get(), Integer.valueOf(testObject + i));
        }
    }

    @Test(timeout = 1000)
    public void singleLong() {
        LogManager.getLogger(getClass()).info("Running test: singleLong()");
        Long testObject = 123023542345234L;
        ObjectStore<Long> objectStore = new ObjectStore<Long>();
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        objectStore.add(testObject);
        Assert.assertEquals(1, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        Assert.assertEquals(objectStore.get(), testObject);
    }

    @Test(timeout = 1000)
    public void multipleLongs() {
        LogManager.getLogger(getClass()).info("Running test: multipleLongs()");
        Long testObject = 0L;
        ObjectStore<Long> objectStore = new ObjectStore<Long>(ObjectStoreTest.MULTIPLE_TEST_SIZE);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            objectStore.add(testObject + i);
        }
        Assert.assertEquals(ObjectStoreTest.MULTIPLE_TEST_SIZE, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            Assert.assertEquals(objectStore.get(), Long.valueOf(testObject + i));
        }
    }

    @Test(timeout = 1000)
    public void singleByte() {
        LogManager.getLogger(getClass()).info("Running test: singleByte()");
        Byte testObject = 2;
        ObjectStore<Byte> objectStore = new ObjectStore<Byte>();
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        objectStore.add(testObject);
        Assert.assertEquals(1, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        Assert.assertEquals(objectStore.get(), testObject);
    }

    @Test(timeout = 1000)
    public void multipleBytes() {
        LogManager.getLogger(getClass()).info("Running test: multipleBytes()");
        Byte testObject = 0;
        ObjectStore<Byte> objectStore = new ObjectStore<Byte>(ObjectStoreTest.MULTIPLE_TEST_SIZE);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            objectStore.add(Byte.valueOf((byte) (testObject + i)));
        }
        Assert.assertEquals(ObjectStoreTest.MULTIPLE_TEST_SIZE, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            Assert.assertEquals(objectStore.get(), Byte.valueOf((byte) (testObject + i)));
        }
    }

    @Test(timeout = 1000)
    public void singleFile() {
        LogManager.getLogger(getClass()).info("Running test: singleFile()");
        File testObject = new File("");
        ObjectStore<File> objectStore = new ObjectStore<File>();
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        objectStore.add(testObject);
        Assert.assertEquals(1, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        Assert.assertEquals(objectStore.get(), testObject);
    }

    @Test(timeout = 1000)
    public void multipleFiles() {
        LogManager.getLogger(getClass()).info("Running test: multipleFiles()");
        ObjectStore<File> objectStore = new ObjectStore<File>(ObjectStoreTest.MULTIPLE_TEST_SIZE);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            objectStore.add(new File("" + i));
        }
        Assert.assertEquals(ObjectStoreTest.MULTIPLE_TEST_SIZE, objectStore.getSize());
        Assert.assertFalse(objectStore.isEmpty());
        for (int i = 0; i < ObjectStoreTest.MULTIPLE_TEST_SIZE; i++) {
            Assert.assertEquals(objectStore.get(), new File("" + i));
        }
    }

    @Test(timeout = 1000)
    public void testPriority() {
        LogManager.getLogger(getClass()).info("Running test: testPriority()");
        ObjectStore<Long> objectStore = new ObjectStore<Long>(10, true);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());

        objectStore.add(3L);
        objectStore.add(2L);
        objectStore.add(1L);

        Assert.assertFalse(objectStore.isEmpty());

        Assert.assertTrue(objectStore.get() == 1L);
        Assert.assertTrue(objectStore.get() == 2L);
        Assert.assertTrue(objectStore.get() == 3L);

        Assert.assertTrue(objectStore.isEmpty());
    }

    @Test(timeout = 3000)
    public void maxSize() {
        LogManager.getLogger(getClass()).info("Running test: maxSize()");
        long startTime = System.currentTimeMillis();
        final ObjectStore<Integer> objectStore = new ObjectStore<Integer>(10);
        Assert.assertEquals(0, objectStore.getSize());
        Assert.assertTrue(objectStore.isEmpty());
        for (int i = 0; i < 10; i++) {
            objectStore.add(i);
        }
        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    LogManager.getLogger(getClass()).error("Error while waiting!", e);
                }
                objectStore.get();
            }

        }.start();
        objectStore.add(0);
        Assert.assertTrue("Store did not block!", System.currentTimeMillis() - startTime > 1000);
    }
}
